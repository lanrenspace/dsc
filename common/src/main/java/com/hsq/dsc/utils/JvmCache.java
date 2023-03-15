package com.hsq.dsc.utils;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
public class JvmCache {

    private final LoadingCache<String, Boolean> loadingCache;

    private JvmCache() {
        loadingCache = CacheBuilder.newBuilder().maximumSize(2000000L).build(new CacheLoader<String, Boolean>() {
            @Override
            public Boolean load(String s) {
                return null;
            }
        });
    }

    private static final JvmCache cache = new JvmCache();

    /**
     * key是否存在
     *
     * @param key 缓存key
     * @return true or false
     */
    public Boolean hasExist(String key) {
        return this.loadingCache.getIfPresent(key);
    }

    /**
     * 获取实例
     *
     * @return 实例对象
     */
    public static JvmCache getInstance() {
        return cache;
    }

    /**
     * 设置缓存
     *
     * @param key
     */
    public void set(String key) {
        this.loadingCache.put(key, true);
    }

    public Long size() {
        return this.loadingCache.size();
    }
}
