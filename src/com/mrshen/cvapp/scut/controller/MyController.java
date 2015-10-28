package com.mrshen.cvapp.scut.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrshen.cvapp.scut.persistent.dao.BaseDao;
import com.mrshen.cvapp.scut.persistent.dao.CuisineEntity;
import com.mrshen.cvapp.scut.persistent.dao.EntityList;
import com.mrshen.cvapp.scut.persistent.dao.MusicEntity;
import com.mrshen.cvapp.scut.persistent.db.JdbcCuisineEntity;
import com.mrshen.cvapp.scut.persistent.db.JdbcMusicEntity;
import com.mrshen.cvapp.scut.persistent.db.Pojo2Json;

@Controller
@RequestMapping("/")
public class MyController {
	
	@Autowired
	private JdbcCuisineEntity jdbcCuisineEntity;
	@Autowired
	private JdbcMusicEntity jdbcMusicEntity;

	@RequestMapping("/cuisine/{cuisineType}")
	@ResponseBody
	public  String cuisineLists(@PathVariable String cuisineType, HttpServletRequest request) {
		String result = null;
		String itemID = null;
		itemID = request.getParameter("id");
		if (itemID == null) {
			List<BaseDao> lists = jdbcCuisineEntity.getList();
			result = Pojo2Json.pojo2String(lists);
		} else {
			CuisineEntity item = (CuisineEntity)jdbcCuisineEntity.getObjById(Integer.parseInt(itemID));
			result = Pojo2Json.pojo2String(item);
		}
		return result;
	}
	
	@RequestMapping("/music/{musicType}")
	@ResponseBody
	public  String musicLists(@PathVariable String musicType, HttpServletRequest request){
		String result = null;
		String itemID = null;
		itemID = request.getParameter("id");
		if (itemID == null) {
			List<BaseDao> lists = jdbcMusicEntity.getList();
			result = Pojo2Json.pojo2String(lists);
		} else {
			MusicEntity item = (MusicEntity)jdbcMusicEntity.getObjById(Integer.parseInt(itemID));
			result = Pojo2Json.pojo2String(item);
		}
		return result;
	}
	
	
	@RequestMapping("/test")
	@ResponseBody
	public void printInfo() {
		System.out.println("jdbcCuisine: " + jdbcCuisineEntity.toString());
		System.out.println("jdbcMusic: " + jdbcMusicEntity.toString());
	}
}
