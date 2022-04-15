package com.tech.spring.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tech.spring.dao.CustomEduDao;

@Service
public class CustomEduServicempl implements CustomEduService{

	@Inject
	CustomEduDao dao;

}
