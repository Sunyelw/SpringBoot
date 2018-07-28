package com.asiainfo.boot.service;

import com.asiainfo.boot.dao.Student;

/**
 * 项目名称:   pinkstone
 * 包:        com.asiainfo.boot.service
 * 类名称:     StudentService
 * 类描述:     student Service
 * 创建人:     huangyang
 * 创建时间:   2018/7/28 22:32
 */
public interface StudentService {

	int insert(Student student);

	Student selectById(int id);

	/**
	 * 第二种缓存写法
	 *
	 * @param id 学生ID
	 * @return 学生对象
	 */
	Student selectByIdCaching(int id);
}
