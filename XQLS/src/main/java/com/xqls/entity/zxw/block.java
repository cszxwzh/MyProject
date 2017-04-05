package com.xqls.entity.zxw;

public class block {
    private Integer blockId;

    private String blockName;

    private String blockNum;

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName == null ? null : blockName.trim();
    }

    public String getBlockNum() {
        return blockNum;
    }


	public void setBlockNum(String blockNum) {
        this.blockNum = blockNum == null ? null : blockNum.trim();
    }
    
	@Override
	public String toString() {
		return "block [blockId=" + blockId + ", blockName=" + blockName
				+ ", blockNum=" + blockNum + "]";
	}
}