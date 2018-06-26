package com.sino.test;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration({"spring.xml"})
public class TESTTT {


		 @Autowired
		    private RedisTemplate redisTemplate;

	private static final Logger log  = Logger.getLogger(TESTTT.class.getName());
	
	@Test
	public void test() {
		  redisTemplate.opsForValue().set("chen", "陈梓平");
	        log.info("value："+redisTemplate.opsForValue().get("chen"));
	}

}
