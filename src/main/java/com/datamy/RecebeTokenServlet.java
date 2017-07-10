package com.datamy;

import com.datamy.main.connection.connectionFactory.ConexaoPGDao;
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.datamy.main.connection.connectionFactory.ConnectionFactory;
import com.datamy.main.dao.UserTokenDao;


/**
 * Servlet implementation class RecebeTokenServlet
 */
@WebServlet("/recebetoken")
public class RecebeTokenServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String token = request.getParameter("token");
				
		UserTokenDao udao = new UserTokenDao();
		udao.saveToken(1, token);
//		udao.close();
	}

}
