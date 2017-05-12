package com.design.test.account.simple;

import com.design.test.account.AccountFactory;
import com.design.test.account.AccountManagementFactory;
import com.design.test.account.AccountObject;

/**
 * @author haichaow
 * @date 2017年5月4日
 * @description
 */
public abstract class AbstractAccountFactory implements AccountFactory, AccountManagementFactory {

	public void addAccount(AccountObject accountObject) throws Exception {
		// TODO Auto-generated method stub

	}

	public void updateAccount(AccountObject accountObject) throws Exception {
		// TODO Auto-generated method stub

	}

	public void removeAccount(AccountObject accountObject) throws Exception {
		// TODO Auto-generated method stub

	}

	public AccountObject getAccount(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
