package com.design.test.account;

/**
 * @author haichaow
 * @date 2017年4月25日
 * @description
 */
public interface IAccountService {

	public AccountObject selectAccountById(String id);

	public void insertAccount(AccountObject account);

	public AccountObject findAccount(String name);

	public void updateAccount(AccountObject account);

	public void deleteAccount(AccountObject account);

}
