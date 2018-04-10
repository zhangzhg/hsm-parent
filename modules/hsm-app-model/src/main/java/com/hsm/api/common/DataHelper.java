package com.hsm.api.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;

@Component
public class DataHelper {
    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 从缓存中拿，取不到从数据库中拿。
     * 要在爬数据的地方清空为key的缓存，这样新数据一来就会直接从数据库中拿
     */
    public Object getData(String key, Callback call) {
        Object value = redisTemplate.opsForValue().get(key);
        if (null == value) {
            Object obj = call.call();
            setData(key, obj);
            return obj;
        } else {
            return value;
        }
    }

    public interface Callback {
        Object call();
    }

    public void setData(String key, Object data) {
        redisTemplate.opsForValue().set(key, data);
    }
}
