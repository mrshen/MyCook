package com.mrshen.cvapp.scut.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrshen.cvapp.scut.model.ConfigInfo;
import com.mrshen.cvapp.scut.model.CuisineEntity;
import com.mrshen.cvapp.scut.model.MusicEntity;
import com.mrshen.cvapp.scut.model.EntityList;
import com.mrshen.cvapp.scut.util.DBmanager;
import com.mrshen.cvapp.scut.util.Pojo2Json;

@Controller
@RequestMapping("/")
public class MyController {
	
	@Autowired
	private ConfigInfo configInfo;
	
	@RequestMapping("/cuisine/{cuisineType}")
	@ResponseBody
	public  String cuisineLists(@PathVariable String cuisineType, HttpServletRequest request) {
		String result = null;
		String itemID = null;
		Connection connection = null;
		try {
			Class.forName(configInfo.getJdbcDriver());
			connection = DriverManager.getConnection(configInfo.getJdbcUrl(), configInfo.getJdbcUsername(), configInfo.getJdbcPassword());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		itemID = request.getParameter("id");
		if (itemID == null) {
			List<EntityList> list = new DBmanager().getCuisineList(cuisineType, connection);
			result = Pojo2Json.pojo2String(list);
		} else {
			CuisineEntity item = new DBmanager().getCuisineItem(itemID, connection);
			result = Pojo2Json.pojo2String(item);
		}
		return result;
	}
	
	@RequestMapping("/music/{musicType}")
	@ResponseBody
	public  String musicLists(@PathVariable String musicType, HttpServletRequest request){
		String result = null;
		String itemID = null;
		Connection connection = null;
		try {
			Class.forName(configInfo.getJdbcDriver());
			connection = DriverManager.getConnection(configInfo.getJdbcUrl(), configInfo.getJdbcUsername(), configInfo.getJdbcPassword());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		itemID = request.getParameter("id");
		if (itemID == null) {
			List<EntityList> list = new DBmanager().getMusicList(musicType, connection);
			result = Pojo2Json.pojo2String(list);
		} else {
			MusicEntity item = new DBmanager().getMusicItem(itemID, connection);
			result = Pojo2Json.pojo2String(item);
		}
		return result;
	}
	
	
	@RequestMapping("/test")
	@ResponseBody
	public void printInfo() {
		System.out.println(configInfo.toString());
	}
}
