package com.design.test.account.simple;

import com.design.test.account.AccountCacheService;
import com.design.test.account.AccountFactory;
import com.design.test.account.AccountManagementFactory;
import com.design.test.account.AccountManager;
import com.design.test.account.AccountObject;
import com.design.test.account.AccountProvider;
import com.design.test.account.IAccountService;
import com.design.test.utils.ApplicationContextUtils;

public abstract class SimpleAccountFactory implements AccountProvider,
		AccountFactory, AccountManagementFactory {
	private IAccountService accountService;

	public AccountFactory getFactory() {
		return this;
	}

	public AccountManagementFactory getManagementFactory() {
		return this;
	}

	public IAccountService getAccountService() {
		if (accountService == null) {
			accountService = (IAccountService) ApplicationContextUtils
					.findInterfaceService(IAccountService.class);
		}
		return accountService;
	}

	public AccountCacheService getCacheService() {
		return AccountManager.getInstance().getCacheService();
	}

	public AccountObject getAccount(String name) throws Exception {
		AccountObject accountObject = getCacheService().getAccount(name);
		if (accountObject == null) {
			accountObject = getAccountService().findAccount(name);
			if (accountObject != null && accountObject.getId() != null
					&& !accountObject.getId().equals("")) {
				getCacheService().setAccount(accountObject);
			}
		}
		return accountObject;
	}


	public void addAccount(AccountObject accountObject) throws Exception {
		getAccountService().insertAccount(accountObject);
	}

	public void updateAccount(AccountObject accountObject) throws Exception {
		getAccountService().updateAccount(accountObject);
		
		AccountObject oldAccountObject = getCacheService().getAccount(
				accountObject.getId());
		if (oldAccountObject != null) {
			getCacheService().removeAccount(oldAccountObject);
		}
		
		getCacheService().setAccount(accountObject);
	}

	public void removeAccount(AccountObject accountObject) throws Exception {
		getAccountService().deleteAccount(accountObject);
		accountObject = getCacheService().getAccount(accountObject.getId());
		if (accountObject != null) {
			getCacheService().removeAccount(accountObject);
		}
	}
}