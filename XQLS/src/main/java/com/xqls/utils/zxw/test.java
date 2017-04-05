package com.xqls.utils.zxw;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.JsonParser;
import com.fasterxml.jackson.core.JsonParseException;
import com.xqls.entity.zxw.SelectPerms;

public class test {
public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
	String ce = "[{'id':'0001','name':'取水口'},{'id':'00010001','name':'实时数据'},{'id':'00010002','name':'操作记录'},{'id':'00010003','name':'流量记录'},{'id':'00010004','name':'生成记录'}]";
	ObjectMapper mapper = new ObjectMapper();  
	mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
	JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, SelectPerms.class); 
	List<SelectPerms> lst =  (List<SelectPerms>)mapper.readValue(ce, javaType); 
	for (SelectPerms selectPerms : lst) {
		System.out.println(selectPerms.getId());
	}
}

}
