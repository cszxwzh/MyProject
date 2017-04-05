package com.xqls.service.zxw;

import java.util.List;

import com.xqls.entity.zxw.TreeResult;
import com.xqls.entity.zxw.block;

public interface blockService {
	List<block> selAll();
	List<TreeResult> selTree();
	int addblock(block block);
	int delblockByNum(String blockNum);
	int updblockByNum(block block);
	block selblockByNum(String blockNum);
	block selblockByNumAndName(block block);
	int selsamenum(String blockNum);
}
