package com.mrshen.cvapp.scut.util;

import java.io.IOException;
import java.security.MessageDigest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Util {
	// generate a json string from pojo
	public static String pojo2String(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		try {
			result = mapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	// generate a token string using string username and string password of class User
	public static String generateToken(String username, String password) {
		return generateMD5(username + ":" + password);
	}
	
	public static String generateMD5(String text) {
		String result = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(text.getBytes());
			byte buf[] = md.digest();
			int i;
			StringBuffer sb = new StringBuffer("");
			for(int offset = 0; offset < buf.length; offset++) {
				i = buf[offset];
				if(i < 0)
					i += 256;
				if(i < 16)
					sb.append("0");
				sb.append(Integer.toHexString(i));
			}
			result = sb.toString();
		} catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
