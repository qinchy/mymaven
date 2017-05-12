package com.design.test.account;

/**
 * 账号操作工厂
 * @author haichao.wang
 *
 */
public interface AccountFactory {

	/**
	 * 获取账号信息.
	 * 
	 * @param name
	 *            账号名称
	 * @return AccountObject 账号对象
	 * @throws Exception
	 */
	public AccountObject getAccount(String name) throws Exception;
}