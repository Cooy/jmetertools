package com.ckt.utils;

/**
 * 
 * @ClassName: TimeUtils 
 * @Description: 
 * @author jianbin.zhong
 * @date 2017年9月28日 上午10:59:31 
 *
 */
public class TimeUtils {
	
	//获取间隔interval 的10位数时间戳
		public String getTimestamp(long interval){
			//传5000就可以了
			//5000 = 80min =1.xx hour    
			String timestamp=String.valueOf(System.currentTimeMillis()/1000+interval);
			return timestamp;
		}
		
		//获取当前时间的10位时间戳
		public String getTimestamp(){
			String timestamp = String.valueOf(System.currentTimeMillis()/1000);
			return timestamp;
		}
		
		//判断字符串中是否都是数字
		public boolean isNumber(String s){
			if(s.matches("\\d+")) {
	            return true;
	        } else {
	            return false;
	        }
		}
}
