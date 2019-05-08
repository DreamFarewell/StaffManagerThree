package cn.com.employee.md5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/**
 * BASE64加密解密
 * 
 * @author 18359
 *
 */
public class MD5Util {
	MessageDigest m;
	BASE64Encoder b;
	String n;
	public String complie(String s){
		try {
			s = s.trim();
			m = MessageDigest.getInstance("MD5");
			b = new BASE64Encoder();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		try {
			n = b.encode(m.digest(s.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return n;
	}
	public static void main(String[] args) {
		String str = new MD5Util().complie("123");
		System.out.println(str);
	}
}
