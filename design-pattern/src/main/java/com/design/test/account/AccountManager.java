package com.design.test.account;

import java.util.Hashtable;
import java.util.Map;

/**
 * 账号管理接口
 * 
 * @author haichao.wang
 *
 */
public class AccountManager {
	private static AccountManager _instance;

	/**
	 * 获取账号接口管理类的实例单例.
	 * 
	 * @return 账号接口管理类
	 */
	public static AccountManager getInstance() {
		if (_instance == null) {
			synchronized (AccountManager.class) {
				if (_instance == null) {
					_instance = new AccountManager();
				}

			}
		}
		return _instance;
	}

	private Map<String, AccountProvider> providers = null;

	AccountManager() {
		providers = new Hashtable<String, AccountProvider>();
	}


	protected String getDefaultProviderName() {
		return "default";
	}

	/**
	 * 获取账号管理提供者
	 * 
	 * @param providerName
	 *            提供者名称
	 * @return 管理提供者
	 */
	public AccountProvider getProvider(String providerName) {
		AccountProvider provider = providers.get(providerName);
		if (provider != null) {
			return provider;
		} else {
			try {
				if (provider != null)
					providers.put(providerName, provider);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return provider;
	}

	/**
	 * 获取默认账号管理提供者,一般请款下默认提供者名称为default.
	 * 
	 * @return 账号提供者
	 */
	public AccountProvider getProvider() {
		return getProvider(getDefaultProviderName());
	}

	/**
	 * 根据默认管理提供者获取其默认管理工厂
	 * 
	 * @return 账号管理工厂
	 */
	public AccountFactory getFactory() {
		return getProvider().getFactory();
	}
	
	private AccountCacheService cacheService;
	
	public synchronized AccountCacheService getCacheService() {
		if (cacheService == null) {
			//TODO  通过配置或其他方式都可
		}
		return cacheService;
	}

}