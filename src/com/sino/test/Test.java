package com.sino.test;

import redis.clients.jedis.Jedis;

public class Test {

	public static void main(String[] args) {
		
	        Jedis jedis = new Jedis("127.0.0.1",6379);  
	        //ping通显示PONG  
	        System.out.println(jedis.ping());//去ping我们redis的主机所在ip和端口  

	}
}
