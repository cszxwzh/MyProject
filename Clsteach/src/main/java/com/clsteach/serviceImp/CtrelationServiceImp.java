package com.clsteach.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clsteach.dao.ctrelationMapper;
import com.clsteach.entity.ctrelation;
import com.clsteach.entity.ctrelationex;
import com.clsteach.service.CtrelationService;
@Service
public class CtrelationServiceImp implements CtrelationService {
	@Autowired
	private ctrelationMapper ctrelationMapper;
	
	@Override
	public int delCtrelation(Integer ctrelationId) {
		return ctrelationMapper.deleteByPrimaryKey(ctrelationId);
	}

	@Override
	public int addCtrelation(ctrelation ctrelation) {
		return ctrelationMapper.insert(ctrelation);
	}

	@Override
	public ctrelation selById(Integer ctrelationId) {
		return ctrelationMapper.selectByPrimaryKey(ctrelationId);
	}

	@Override
	public int update(ctrelation ctrelation) {
		return ctrelationMapper.updateByPrimaryKey(ctrelation);
	}

	@Override
	public ctrelationex selByclsAndsta(ctrelation ctrelation) {
		return ctrelationMapper.selectByclsAndsta(ctrelation);
	}

}
