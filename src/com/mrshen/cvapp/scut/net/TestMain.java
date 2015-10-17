package com.mrshen.cvapp.scut.net;

import org.springframework.beans.factory.annotation.Autowired;

import com.mrshen.cvapp.scut.model.ConfigInfo;

public class TestMain {
	
	@Autowired
	private ConfigInfo configInfo;
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = null;
		result += "Driver = " + configInfo.getJdbcDriver() + '\n';
		result += "Url = " + configInfo.getJdbcUrl() + '\n';
		result += "Username = " + configInfo.getJdbcUsername() + '\n';
		result += "Password = " + configInfo.getJdbcPassword();
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new TestMain().toString());
	}

}
