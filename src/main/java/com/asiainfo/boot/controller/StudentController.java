package com.asiainfo.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.boot.dao.Student;
import com.asiainfo.boot.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 项目名称:   pinkstone
 * 包:        com.asiainfo.boot.controller
 * 类名称:     StudentController
 * 类描述:     For mybatis/log/redis/actuator
 * 创建人:     HuangYang
 * 创建时间:   2018/7/28 22:39
 */
@RestController
@Slf4j
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping("/stu/select/{id}")
	public String selectStudent(@PathVariable("id") int id) {
		Student student = studentService.selectById(id);
		return JSONObject.toJSONString(student);
	}

	@RequestMapping("/stu/insert")
	public int insertStudent() {
		Student student = new Student(null, 24, "yelw", new Date());
		log.debug(student.toString());
		return studentService.insert(student);
	}

}
