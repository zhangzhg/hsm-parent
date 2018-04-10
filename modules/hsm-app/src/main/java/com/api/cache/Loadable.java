package com.api.cache;

public interface Loadable<T> {
    T reload(Object... args) throws Exception;
}
