package com.ivan.mall.util;

import java.util.Random;

/**
 * 随机生成ID的工具类
 * 
 * @author Ivan
 *
 */

public class IDUtil {
	/**
	 * 随机生成图片的Id
	 * 
	 * @return 图片Id
	 */
	public static String getImageName() {
		// 获取当前时间毫秒值
		long millis = System.currentTimeMillis();
		// 毫秒不行用纳秒
		// long millis = System.nanoTime()
		// 加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		// 如果三位不足,在前面补0
		String str = millis + String.format("%03d", end3);

		// 返回随机数字串
		return str;
	}

	/**
	 * 随机生成Id
	 * 
	 * @return Id
	 */
	public static long getId() {
		// 获取当前时间毫秒值
		long millis = System.currentTimeMillis();
		// 毫秒不行用纳秒
		// long millis = System.nanoTime()
		// 加上三位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		// 如果三位不足,在前面补0
		String str = millis + String.format("%02d", end2);

		long id = new Long(str);
		// 返回随机数字串
		return id;
	}

	/**
	 * 测试工具类方法
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getImageName());
	}
}
