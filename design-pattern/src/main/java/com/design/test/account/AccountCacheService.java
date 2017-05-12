package com.design.test.account;

/**
 * 账号缓存服务
 * @author haichao.wang
 *
 */
public interface AccountCacheService {

	/**
	 * 获取账号信息缓存
	 * 
	 * @param name
	 *            支持name或者id
	 * @return 缓存的账号信息
	 * @throws Exception
	 */
	public AccountObject getAccount(String name) throws Exception;

	/**
	 * 放置一个账号信息到缓存中
	 * 
	 * @param accountObject
	 *            账号信息对象
	 * @throws Exception
	 */
	public void setAccount(AccountObject accountObject) throws Exception;

	/**
	 * 从缓存中移除一个账号信息
	 * 
	 * @param accountObject
	 *            账号信息对象
	 * @throws Exception
	 */
	public void removeAccount(AccountObject accountObject) throws Exception;
}