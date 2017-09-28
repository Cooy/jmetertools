package com.ckt.jmeterutils;

import org.junit.Assert;
import org.junit.Test;

import com.ckt.utils.PictureUtils;

/**
 * 
 * @ClassName: PictureUtilsTest 
 * @Description: test methods in PictureUtils class  if is ok
 * @author jianbin.zhong
 * @date 2017年9月27日 下午5:07:16 
 *
 */
public class PictureUtilsTest {
	
	@Test
	//test isPicExist method true
	public void testIsPicExist(){
		String rightPicture = "testresource/testpicture.jpg";
		Assert.assertTrue(new PictureUtils().isPicExist(rightPicture));
	}
	
	@Test
	//test isPicExist method false
	public void testIsPicNotExist(){
		String wrongPicture = "testresource2/testpicture.jpg";
		Assert.assertFalse(new PictureUtils().isPicExist(wrongPicture));
	}
	
	@Test
	//test getType jpg
	public void testGetTypeJpg(){
		String jpgPicture = "testresource/testpicture.jpg";
		Assert.assertEquals(".jpg", new PictureUtils().getType(jpgPicture));
	}
	
	@Test
	//test getType png
	public void testGetTypePng(){
		String pngPicture = "testresource/testpicture1.png";
		Assert.assertEquals(".png", new PictureUtils().getType(pngPicture));
	}
	
	@Test
	//test isPic
	public void testIsPic(){
		String picture = "testresource/testpicture1.png";
		Assert.assertTrue(new PictureUtils().isPic(picture));
	}
	
	@Test
	//test is not pic
	public void testIsNotPic(){
		String vide = "myvideo.mp4";
		Assert.assertFalse(new PictureUtils().isPic(vide));
	}
	
	
	
	
}
