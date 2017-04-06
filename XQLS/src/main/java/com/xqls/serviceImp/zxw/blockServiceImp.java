package com.xqls.serviceImp.zxw;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xqls.dao.zxw.blockMapper;
import com.xqls.entity.zxw.TreeResult;
import com.xqls.entity.zxw.block;
import com.xqls.service.zxw.blockService;

@Service()
public class blockServiceImp implements blockService{
	@Autowired
	private blockMapper blockMapper;
	
	@Override
	public List<block> selAll() {
		return blockMapper.selectAll();
	}

	@Override
	public List<TreeResult> selTree() {
		List<block> blist = selAll();
		List<TreeResult> treelist = new ArrayList<TreeResult>();
		for (block block : blist) {
			TreeResult treeResult = new TreeResult();
			int length = block.getBlockNum().length();
			if (length<5) {
				treeResult.setId(block.getBlockNum());
				treeResult.setName(block.getBlockName());
				treeResult.setIsParent(true);
				treeResult.setOpen(false);
				treeResult.setpId("0");
			}else{
				treeResult.setId(block.getBlockNum());
				treeResult.setName(block.getBlockName());
				treeResult.setIsParent(false);
				treeResult.setOpen(false);
				treeResult.setpId(block.getBlockNum().substring(0, length-4));
			}
			treelist.add(treeResult);
		}
		return treelist;
	}

	@Override
	public int addblock(block block) {
		return blockMapper.insert(block);
	}

	@Override
	public int delblockByNum(String blockNum) {
		return blockMapper.deleteByNum(blockNum);
	}

	@Override
	public int updblockByNum(block block) {
		return blockMapper.updateByNum(block);
	}

	@Override
	public block selblockByNum(String blockNum) {
		return blockMapper.selectByNum(blockNum);
	}

	@Override
	public block selblockByNumAndName(block block) {
		return blockMapper.selectByNumAndName(block);
	}

	@Override
	public int selsamenum(String blockNum) {
		return blockMapper.seletSameNum(blockNum);
	}

}
