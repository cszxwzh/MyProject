package com.clsteach.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clsteach.dao.stageMapper;
import com.clsteach.entity.stage;
import com.clsteach.entity.stageex;
import com.clsteach.service.StageService;

@Service
public class StageServiceImp implements StageService {
	@Autowired
	private stageMapper stageMapper;
	@Override
	public int delstage(Integer stageId) {
		return stageMapper.deleteByPrimaryKey(stageId);
	}

	@Override
	public int addstage(stage stage) {
		return stageMapper.insert(stage);
	}

	@Override
	public stage selById(Integer stageId) {
		return stageMapper.selectByPrimaryKey(stageId);
	}

	@Override
	public int update(stage stage) {
		return stageMapper.updateByPrimaryKey(stage);
	}

	@Override
	public List<stage> selAll() {
		return stageMapper.selectAll();
	}

	@Override
	public List<stageex> selectByclsteach(int clsId) {
		return stageMapper.selectByclsteach(clsId);
	}
	
}
