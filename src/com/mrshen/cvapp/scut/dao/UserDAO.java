package com.mrshen.cvapp.scut.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrshen.cvapp.scut.model.MusicEntity;

public interface UserDAO extends JpaRepository<MusicEntity, Integer>{
	public MusicEntity findByName(String name);
}
