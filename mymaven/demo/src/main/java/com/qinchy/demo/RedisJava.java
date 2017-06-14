package com.qinchy.demo;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

public class RedisJava {
	public static void main(String[] args) {
		// 连接本地的 Redis 服务
//		Jedis jedis = new Jedis("localhost",6379,5000);
		Jedis jedis = new Jedis("localhost");
//		JedisShardInfo shardInfo = new JedisShardInfo("localhost");
//		Jedis jedis = new Jedis(shardInfo);
		System.out.println("Connection to server sucessfully");

		// 查看服务是否运行
		System.out.println("Server is running: " + jedis.ping());

		// 设置 redis 字符串数据
		// Redis Java String(字符串) 实例
		jedis.set("runoobkey", "Redis tutorial");
		// 获取存储的数据并输出
		System.out.println("Stored string in redis:: " + jedis.get("runoobkey"));

		// 存储数据到列表中
		// Redis Java List(列表) 实例
		jedis.lpush("tutorial-list", "Redis");
		jedis.lpush("tutorial-list", "Mongodb");
		jedis.lpush("tutorial-list", "Mysql");
		// 获取存储的数据并输出
		List<String> list1 = jedis.lrange("tutorial-list", 0, 5);
		for (int i = 0; i < list1.size(); i++) {
			System.out.println("Stored string in redis:: " + list1.get(i));
		}

		// 获取数据并输出
		Set<String> set2 = jedis.keys("*");
		Iterator<String> it;
		for(it = set2.iterator();it.hasNext();){
			String str = it.next();
			System.out.println(str);
		}
		
	}
}