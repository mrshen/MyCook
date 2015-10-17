package com.mrshen.cvapp.scut.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;

import com.mrshen.cvapp.scut.model.ConfigInfo;
import com.mrshen.cvapp.scut.model.CuisineEntity;
import com.mrshen.cvapp.scut.model.MusicEntity;
import com.mrshen.cvapp.scut.model.EntityList;

public class DBmanager {

	/*private final static String DB_URL = "jdbc:mysql://localhost:3306/mycook";
	private final static String USER = "root";
	private final static String PASSWORD = "mrshen";
	private final static String DRIVER = "com.mysql.jdbc.Driver";*/
//	@Autowired
//	private ConfigInfo configInfo;
	
//	private static final String SQL_ROOT = "SELECT * FROM ";
	
	public List<EntityList> getMusicList(String musicType, Connection connection) {
//		Connection connection = null;
		List<EntityList> lists = new ArrayList<EntityList>();
		try {
			/*Class.forName(DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);*/
//			Class.forName(configInfo.getJdbcDriver());
//			connection = DriverManager.getConnection(configInfo.getJdbcUrl(), configInfo.getJdbcUsername(), configInfo.getJdbcPassword());
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT songId, songName FROM music WHERE songType=" + musicType);
			
			while(resultSet.next()) {
				int id = resultSet.getInt("songId");
				String name = resultSet.getString("songName");
				EntityList user = new EntityList(id, name);
				lists.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return lists;
	}
	
	public MusicEntity getMusicItem(String itemId, Connection connection) {
			
//			Connection connection = null;
			MusicEntity item = null;
			try {
				/*Class.forName(DRIVER);
				connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);*/
//				Class.forName(configInfo.getJdbcDriver());
//				connection = DriverManager.getConnection(configInfo.getJdbcUrl(), configInfo.getJdbcUsername(), configInfo.getJdbcPassword());
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM music WHERE songId=" + itemId);
				
				if(resultSet.next()) {
					int id = resultSet.getInt("songId");
					String name = resultSet.getString("songName");
					String addr = resultSet.getString("songAddr");
					String type = resultSet.getString("songType");
					item = new MusicEntity(id, name, addr, type);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			return item;
		}
	
	public List<EntityList> getCuisineList(String cuisineType, Connection connection) {
			
//			Connection connection = null;
			List<EntityList> lists = new ArrayList<EntityList>();
			try {
				/*Class.forName(DRIVER);
				connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);*/
//				Class.forName(configInfo.getJdbcDriver());
//				connection = DriverManager.getConnection(configInfo.getJdbcUrl(), configInfo.getJdbcUsername(), configInfo.getJdbcPassword());
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT dishId, dishName FROM cuisine WHERE dishType=" + cuisineType);
				
				while(resultSet.next()) {
					int id = resultSet.getInt("dishId");
					String name = resultSet.getString("dishName");
					EntityList user = new EntityList(id, name);
					lists.add(user);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			return lists;
		}
	
	public CuisineEntity getCuisineItem(String itemId, Connection connection) {
		CuisineEntity item = null;
//		Connection connection = null;
		try {
			/*Class.forName(DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);*/
//			Class.forName(configInfo.getJdbcDriver());
//			connection = DriverManager.getConnection(configInfo.getJdbcUrl(), configInfo.getJdbcUsername(), configInfo.getJdbcPassword());
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM cuisine WHERE dishId=" + itemId);
			
			if(resultSet.next()) {
				int id = resultSet.getInt("dishId");
				String name = resultSet.getString("dishName");
				String vname = resultSet.getString("dishVideoAddr");
				String desc = resultSet.getString("dishDesc");
				int type = resultSet.getInt("dishType");
				item = new CuisineEntity(id, name, vname, desc, type);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return item;
	}
}
