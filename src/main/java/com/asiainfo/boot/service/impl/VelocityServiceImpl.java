package com.asiainfo.boot.service.impl;

import com.asiainfo.boot.service.VelocityService;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Properties;

/**
 * 项目名称:   pinkstone
 * 包:        com.asiainfo.boot.service.impl
 * 类名称:     VelocityServiceImpl
 * 类描述:     velocity ServiceImpl
 * @author :    huangyang
 * 创建时间:   2018/7/25 8:33
 */
@Service
public class VelocityServiceImpl implements VelocityService {

	@Override
	public String getMessageByVm(String vmPath, String[] name) {

		Properties p = new Properties();
		// 设置velocity资源加载方式为class
		// 设置从classpath路径下加载文件（重要）
		p.setProperty("resource.loader", "class");
		// 设置velocity资源加载方式为file时的处理类
		p.setProperty("class.resource.loader.class",
				"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		VelocityContext context = new VelocityContext();
		context.put("name", name[0]);
		context.put("nickname", name[1]);
		StringWriter writer = new StringWriter();

		VelocityEngine velocityEngine = new VelocityEngine(p);
		velocityEngine.mergeTemplate(vmPath, "UTF-8", context, writer);

		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return writer.toString();
	}
}
