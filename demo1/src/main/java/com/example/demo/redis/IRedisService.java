package com.example.demo.redis;


import com.example.demo.redis.entity.RedisObject;

/**
 *
 */
public interface IRedisService {

	/**
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 * @param expiredSeconds
	 *            失效时间
	 */
	public void set(String key, String value, int expiredSeconds);

	/**
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 */
	public void set(String key, String value);
	
	/**
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 */
	public long setnx(String key, String value);

	/**
	 * 
	 * @param key
	 *            键
	 * @param expiredSeconds
	 *            失效时间
	 */
	public void expire(String key, int expiredSeconds);

	/**
	 * 
	 * @param key
	 *            键
	 * @return
	 */
	public String get(String key);

	/**
	 * 
	 * @param key
	 *            键
	 */
	public void del(String key);

	/**
	 * 
	 * @param key
	 *            键
	 * @param object
	 *            值对象
	 */
	public void setObject(String key, RedisObject object);

	/**
	 * 
	 * @param key
	 *            键
	 * @param object
	 *            值对象
	 * @param expiredSeconds
	 *            失效时间
	 */
	public void setObject(String key, RedisObject object, int expiredSeconds);

	/**
	 * 
	 * @param key
	 *            键
	 * @return 值对象
	 */
	public RedisObject getObject(String key);
}