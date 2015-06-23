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
		AlunoApplication ap = new AlunoApplication();
		Aluno a = new Aluno();
		String id = request.getParameter("_id");
		
		StringBuffer mensagem = new StringBuffer();
		
		try
		{
			if(request.getParameter("nome").isEmpty() == false)
			{
				mensagem.append("Preencha o campo de nome!");
				a.setNome(request.getParameter("nome"));
			}
			if(request.getParameter("nota").isEmpty() == false)
			{
				mensagem.append("Preencha o campo de nota");
				a.setNota(Integer.parseInt(request.getParameter("nota")));
			}
			if(request.getParameter("falta").isEmpty() == false)
			{
				mensagem.append("Preencha o campo de falta");
				a.setFalta(Integer.parseInt(request.getParameter("falta")));
			}
			if(request.getParameter("matricula").isEmpty() == false)
			{
				mensagem.append("Preencha o campo de matricula!");
				a.setNome(request.getParameter("matricula"));
			}
			if(request.getParameter("periodo").isEmpty() == false)
			{
				mensagem.append("Preencha o campo de periodo!");
				a.setNome(request.getParameter("periodo"));
			}
			mensagem.append(ap.create(a));
			response.setContentType("text/html");
			 
			List<Aluno> alunos = ap.todos();
			request.setAttribute("alunos", alunos);
			mensagem = mensagem.equals(null) ? mensagem.append("Salvo com sucesso!") : mensagem;
			request.setAttribute("mensagem", mensagem);
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			
		}
		catch(Exception ex)
		{
			mensagem.append(ex.getMessage());
		}
}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		AlunoApplication ap = new AlunoApplication();
		response.setContentType("text/html");
		List<Aluno> alunos = new ArrayList<Aluno>();
		String mensagem = "";
		request.setAttribute("alunos", alunos);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
}
