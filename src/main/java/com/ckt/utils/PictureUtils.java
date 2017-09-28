package com.ckt.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 * @ClassName: PictureUtils 
 * @Description: 
 * @author jianbin.zhong
 * @date 2017年9月27日 下午5:06:31 
 *
 */
public class PictureUtils {

	// 图片转base64
	public String pic2Base64(String pic) {
		InputStream in = null;
		byte[] data = null;
		String title = "data:image/jpeg;base64,";

		if (!isPicExist(pic)) {
			System.out.println("Please input a right picture path!");
			return null;
		}
		if (!isPic(getType(pic))) {
			System.out.println("picture type error!");
			return null;
		}
		try {
			in = new FileInputStream(pic);
			data = new byte[(in.available())];
			in.read(data);
			in.close();
		} catch (Exception e) {
			System.out.println("picture to base64 fail");
		}
		return title + new String(Base64.encodeBase64(data));
	}

	// 判断是否是这些格式.jpg .png .jpeg .bmp的图片
	public boolean isPic(String pic){
		String type = getType(pic);
		if (getTypeList().contains(type)) {
			System.out.println(pic+" is a picture!");
			return true;
		} else {
			System.out.println("Picture Type Error! " + type + " does not permit!");
			return false;
		}
	}

	// 获取允许的定义的图片格式列表
	public ArrayList<String> getTypeList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add(".jpg");
		list.add(".png");
		list.add(".jpeg");
		list.add(".bmp");
		return list;
	}

	// 获取字符串结尾
	public String getType(String pic) {
		String type = "." + pic.substring(pic.lastIndexOf(".") + 1, pic.length()).toLowerCase();
		System.out.println("type is: " + type);
		return type;
	}

	// 判断图片是否存在
	public boolean isPicExist(String pic) {
		File file = new File(pic);
		if (!file.exists()) {
			System.out.println("error! " + pic + " does not exist!");
			return false;
		} else {
			System.out.println(pic + " exist!");
			return true;
		}
	}
}
