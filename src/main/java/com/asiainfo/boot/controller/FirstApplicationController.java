package com.asiainfo.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 项目名称:   pinkstone
 * 包:        com.asiainfo.boot.controller
 * 类名称:     FirstApplicationController
 * 类描述:     First Controller
 * @author :     huangyang
 * 创建时间:   2018/7/24 22:50
 */
@RestController
public class FirstApplicationController {

	private static final int SIX = 6;

	@RequestMapping(value = "/test/helloWorld", method = RequestMethod.GET)
	public String sayHelloWorld(){

		StringBuilder res = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < SIX; i++) {
			if (i % 2 == 0) {
				res = res.append(random.nextInt(10));
			} else {
				int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
				res = res.append((char) (random.nextInt(26) + temp));
			}
		}
		return res.toString();
	}


	/**
	 * 深度优先遍历  全排列算法
	 * @param args
	 */
	public static void main(String[] args) {

		List<List<Integer>> ls = permute(new int[]{1, 2, 3});
		for (List<Integer> l : ls ){
			for (Integer i : l) {
				System.out.print(i);
			}
			System.out.println();
		}

	}
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		// Arrays.sort(nums); // not necessary
		backtrack(list, new ArrayList<>(), nums);
		return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
		if(tempList.size() == nums.length){
			list.add(new ArrayList<>(tempList));
		} else{
			for(int i = 0; i < nums.length; i++){
				// element already exists, skip
				if (tempList.contains(nums[i])) {
					continue;
				}
				tempList.add(nums[i]);
				backtrack(list, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
