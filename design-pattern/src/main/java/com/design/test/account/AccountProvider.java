package com.design.test.account;

/**
 * 账号提供者接口
 * @author haichao.wang
 *
 */
public interface AccountProvider {
	/**
	 * 获取账号操作工厂
	 * 
	 * @return 账号工厂
	 */
	public AccountFactory getFactory();

	/**
	 * 获取账号管理工厂
	 * 
	 * @return 账号管理工厂
	 */
	public AccountManagementFactory getManagementFactory();

}
