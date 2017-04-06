package com.clsteach.service;

import com.clsteach.entity.ctrelation;
import com.clsteach.entity.ctrelationex;

public interface CtrelationService {
	public int delCtrelation(Integer ctrelationId);
	 public int addCtrelation(ctrelation ctrelation);
	 public ctrelation selById(Integer ctrelationId);
	 public int update(ctrelation ctrelation);
	 public ctrelationex selByclsAndsta(ctrelation ctrelation);
}
