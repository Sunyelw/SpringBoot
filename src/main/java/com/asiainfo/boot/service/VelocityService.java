package com.asiainfo.boot.service;

/**
 * 项目名称:   pinkstone
 * 包:        com.asiainfo.boot.service
 * 类名称:     VelocityService
 * 类描述:     velocity app
 * 创建人:     huangyang
 * 创建时间:   2018/7/25 8:31
 */
public interface VelocityService {

	/**
	 * 获取模板对应的字符串
	 *
	 * @param vmPath 文件路径
	 * @param name 替换变量
	 * @return 模板信息
	 */
	String getMessageByVm(String vmPath, String[] name);

}
