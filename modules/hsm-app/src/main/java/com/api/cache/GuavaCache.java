package com.api.cache;

import com.api.em.RestUrlEnum;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 *  如果有1000个一样的请求，同时只有只有1个线程取请求，其他的等待返回。
 *
 */
public class GuavaCache {
    private static final Map<String, LoadingCache<String, ?>> loaders = new HashMap<>();

    public static <T> T getCacheLoader(RestUrlEnum em, String key, Loadable<T> reLoader, Object... args) throws ExecutionException {
        String type = em.toString();
        if (null != loaders.get(type)) {
            return (T) loaders.get(type).get(key);
        }

        LoadingCache<String, T> cacheLoader= CacheBuilder
                .newBuilder()
                .maximumSize(100)
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .build(new RefreshKeepCacheLoader<String, T>() {
                    @Override
                    public T load(String key) throws Exception {
                        return reLoader.reload(args);
                    }
                });

        loaders.put(type, cacheLoader);

        return cacheLoader.get(key);
    }

}
