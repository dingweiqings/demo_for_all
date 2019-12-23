package com.ding.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

public class TestHttpRequestHandlerAdapter implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
	arg0.getRequestDispatcher("/WEB-INF/views/allUsers.jsp").forward(arg0, arg1);	
	}

}
