package com.clsteach.contorl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clsteach.entity.stage;
import com.clsteach.service.StageService;

@Controller
@RequestMapping("/jsp/stage")
public class stageControl {
@Autowired
private StageService sService;
@RequestMapping("/list")
public String selAll(HttpServletRequest request) {
	List<stage> list = sService.selAll();
	request.setAttribute("list", list);
	return "jsp/stage/stagelist";
}
}
