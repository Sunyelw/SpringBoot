package com.asiainfo.boot.service.impl;

import com.asiainfo.boot.dao.Student;
import com.asiainfo.boot.mapper.StudentMapper;
import com.asiainfo.boot.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * 项目名称:   pinkstone
 * 包:        com.asiainfo.boot.service.impl
 * 类名称:     StudentServiceImpl
 * 类描述:     student serviceImpl
 * 创建人:     huangyang
 * 创建时间:   2018/7/28 22:32
 */
@Service
@Slf4j
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentMapper studentMapper;

	@Autowired
	RedisTemplate redisTemplate;

	@Override
	public int insert(Student student) {
		log.info("插入数据 ： " + student.toString());
		return studentMapper.insertStudent(student);
	}

	@Override
	public Student selectById(int id) {
		ValueOperations<Integer, Student> template = redisTemplate.opsForValue();
		Student student = template.get(id);
		if (student == null) {
			log.info("{}未曾命中缓存。。", id);
			Student s1 = studentMapper.selectStudent(id);
			template.set(id, s1);
			return s1;
		}
		log.info("{}命中缓存！！", id);
		return student;
	}

	@Cacheable(value = "student", key = "id")
	@Override
	public Student selectByIdCaching(int id) {
		log.warn("{} 缓存未命中", id);
		return studentMapper.selectStudent(id);
	}
}
