package com.api.cache;


import com.google.common.cache.CacheLoader;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/**
 * 找不到的话，一个请求去更新，其他的返回旧值，防止阻塞
 */
public abstract class RefreshKeepCacheLoader<K, V> extends CacheLoader<K, V> {
    public ListenableFuture<V> reload(K key, V oldValue) throws Exception {
        V newValue = null;
        try {
            newValue = this.load(key);
        } catch (Exception e) {

        }

        if(newValue == null) {
            newValue = oldValue;
        }
        return Futures.immediateFuture(newValue);
    }
}
