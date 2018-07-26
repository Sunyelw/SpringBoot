package com.asiainfo.boot.practice;

import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * 项目名称:   pinkstone
 * 包:        com.asiainfo.boot.controller
 * 类名称:     MainClass
 * 类描述:     main clas
 * @author :   huangyang
 * 创建时间:   2018/7/25 15:06
 */
public class MainClass {


	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("a");

		System.out.println(getSms(8));

	}

	/**
	 * 获取不重复的短信验证码
	 *
	 * @param length 验证码位数
	 * @return
	 */
	static String getSms(int length) {

		Set<Character> chars = new HashSet<>();
		Random random = new Random();
		for (int i = 0; i < i + 1; i++) {
			if (chars.size() == length) {
				break;
			} else {
				if (i % 2 == 0) {
					chars.add(String.valueOf(random.nextInt(10)).toCharArray()[0]);
				} else {
					int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
					chars.add((char) (random.nextInt(26) + temp));
				}
			}
		}
		return StringUtils.join(chars.toArray());
	}
}
