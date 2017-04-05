package com.xqls.entity.zxw;

public class equipment {
    private Integer equipId;

    private String equipName;

    private String equipType;

    private Integer blockId;
    
    private String blockNum;
    
    public String getBlockNum() {
		return blockNum;
	}

	public void setBlockNum(String blockNum) {
		this.blockNum = blockNum;
	}

	public Integer getEquipId() {
        return equipId;
    }

    public void setEquipId(Integer equipId) {
        this.equipId = equipId;
    }

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName == null ? null : equipName.trim();
    }

    public String getEquipType() {
        return equipType;
    }

    public void setEquipType(String equipType) {
        this.equipType = equipType == null ? null : equipType.trim();
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

	@Override
	public String toString() {
		return "equipment [equipId=" + equipId + ", equipName=" + equipName
				+ ", equipType=" + equipType + ", blockId=" + blockId + "]";
	}
    
}