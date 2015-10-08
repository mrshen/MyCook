package com.mrshen.cvapp.scut.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrshen.cvapp.scut.model.CuisineEntity;
import com.mrshen.cvapp.scut.model.MusicEntity;
import com.mrshen.cvapp.scut.model.EntityList;
import com.mrshen.cvapp.scut.util.DBmanager;
import com.mrshen.cvapp.scut.util.Pojo2Json;

@Controller
@RequestMapping("/")
public class MyController {
	@RequestMapping("/cuisine/{cuisineType}")
	@ResponseBody
	public  String cuisineLists(@PathVariable String cuisineType, HttpServletRequest request){
		String result = null;
		String itemID = null;
		itemID = request.getParameter("id");
		if (itemID == null) {
			List<EntityList> list = DBmanager.getCuisineList(cuisineType);
			result = Pojo2Json.pojo2String(list);
		} else {
			CuisineEntity item = DBmanager.getCuisineItem(itemID);
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
			List<EntityList> list = DBmanager.getMusicList(musicType);
			result = Pojo2Json.pojo2String(list);
		} else {
			MusicEntity item = DBmanager.getMusicItem(itemID);
			result = Pojo2Json.pojo2String(item);
		}
		return result;
	}
}
