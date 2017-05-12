package com.design.test.account;

/**
 * 账号管理工厂
 * @author haichao.wang
 *
 */
public interface AccountManagementFactory {

	/**
	 * 添加账号.
	 * 
	 * @param accountObject
	 *            账号对象
	 * @throws Exception
	 */
	public void addAccount(AccountObject accountObject) throws Exception;

	/**
	 * 更新账号.
	 * 
	 * @param accountObject
	 *            账号对象
	 * @throws Exception
	 */
	public void updateAccount(AccountObject accountObject) throws Exception;

	/**
	 * 删除账号.
	 * 
	 * @param accountObject
	 *            账号对象
	 * @throws Exception
	 */
	public void removeAccount(AccountObject accountObject) throws Exception;
}