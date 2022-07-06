package org.o7planning.tutorial.helloosgi.mathservice.impl;

import org.o7planning.tutorial.helloosgi.mathservice.MathService;

public class MathServiceImpl implements MathService {

	@Override
	public int sum(int a, int b) {
		return a + b;
	}

	@Override
	public int divide(int a, int b) {
		// TODO Auto-generated method stub
		return a/b;
	}

}