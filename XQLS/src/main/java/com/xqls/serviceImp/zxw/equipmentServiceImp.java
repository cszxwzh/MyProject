package com.xqls.serviceImp.zxw;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xqls.dao.zxw.equipmentMapper;
import com.xqls.entity.zxw.equipment;
import com.xqls.service.zxw.equipmentService;
@Service
public class equipmentServiceImp implements equipmentService{
	@Autowired
	private equipmentMapper equipmentMapper;
	@Override
	public List<equipment> selAll() {
		return equipmentMapper.selectAll();
	}
	@Override
	public List<Map> selByPage(Map<String, Object> map) {
		return equipmentMapper.selectPage(map);
	}
	@Override
	public int selByCount(Map<String, Object> map) {
		return equipmentMapper.selectCount(map);
	}
	@Override
	public Map selById(int equipId) {
		return equipmentMapper.selectById(equipId);
	}
	@Override
	public int addequip(equipment equipment) {
		return equipmentMapper.insert(equipment);
	}
	@Override
	public int updequip(equipment equipment) {
		return equipmentMapper.updateByPrimaryKey(equipment);
	}
	@Override
	public int delequip(int equipId) {
		return equipmentMapper.deleteByPrimaryKey(equipId);
	}
	@Override
	public List<equipment> selByBlock(String blockNum) {
		return equipmentMapper.selectByBlock(blockNum);
	}

}
