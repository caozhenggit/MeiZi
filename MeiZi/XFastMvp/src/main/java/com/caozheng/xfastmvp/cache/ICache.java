package com.caozheng.xfastmvp.cache;

/**
 * @author caozheng
 * @date 2016/11/27
 *
 * describe:
 */
public interface ICache {
    void put(String key, Object value);

    Object get(String key);

    void remove(String key);

    boolean contains(String key);

    void clear();

}
