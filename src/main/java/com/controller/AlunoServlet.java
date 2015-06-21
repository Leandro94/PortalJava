package com.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JetSkiServlet")
public class AlunoServlet extends HttpServlet
{
	private static final long serialVersionUID = -7321681160776582861L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		AlunoApplication jsa = new AlunoApplication();
		Aluno j = new Aluno();
		String id = request.getParameter("_id");

		j.setNome(request.getParameter("nome"));
		j.setMatricula(request.getParameter("matricula"));
		j.setMatricula(request.getParameter("periodo"));
		j.setFalta(Integer.parseInt(request.getParameter("falta")));
		j.setNota(Integer.parseInt(request.getParameter("nota")));
		String mensagem = jsa.validar(request.getParameter("nome"), request.getParameter("nota"), request.getParameter("periodo"), request.getParameter("falta"), request.getParameter("matricula"));
		if(mensagem == null)
			mensagem = jsa.create(j);
		List<Aluno> jsl = new ArrayList<Aluno>();
		try
		{
			jsl = jsa.todos();
		}
		catch(Exception ex)
		{
			mensagem = ex.getMessage();
		}
		getServletContext().setAttribute("alunos", jsl);
		getServletContext().setAttribute("mensagem", mensagem);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		AlunoApplication jsa = new AlunoApplication();
		List<Aluno> jsl = new ArrayList<Aluno>();
		String mensagem = "";
		try
		{
			jsl = jsa.todos();
		}
		catch(Exception ex)
		{
			mensagem = ex.getMessage();
		}
		getServletContext().setAttribute("alunos", jsl);
		getServletContext().setAttribute("mensagem", mensagem);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
	
}
