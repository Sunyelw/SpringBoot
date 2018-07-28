package com.asiainfo.boot.practice;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称:   pinkstone
 * 包:        com.asiainfo.boot.practice
 * 类名称:     SunMap
 * 类描述:     sun to test hashMap
 * @author:     HuangYang
 * 创建时间:   2018/7/28 9:11
 */
@Slf4j
public class SunMap {

	/**
	 * for find Map source code
	 */
	private static Map<String, String> map = new HashMap<>();

	public static void main(String[] args) {

		map.put(null, "a");
		map.put("a", null);
		log.info(map.get(null));
		log.info(map.get("a"));

		User user1 = new User(1);
		User user2 = new User(1);
		// false
		System.out.println(user1 == user2);
		// true
		System.out.println(user1.equals(user2));
	}
}

