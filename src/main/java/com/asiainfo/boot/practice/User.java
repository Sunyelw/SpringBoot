package com.asiainfo.boot.practice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HuangYang
 * @result: == 比较的是内存地址，equals方法可以重写，hashCode方法返回的值用于在TreeSet中比较
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
class User{

	private int age;

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			if (this.getAge() == ((User) obj).getAge())
				return true;
		}
		return false;
	}
}
