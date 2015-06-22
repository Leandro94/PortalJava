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
				mensagem.append("Preencha o campo de nota!");
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
			mensagem.append(jsa.create(a));
			response.setContentType("text/html");
			 
			List<Aluno> cl = jsa.todos();
			request.setAttribute("alunos", cl);
			mensagem = mensagem.equals(null) ? mensagem.append("Salvo com sucesso!") : mensagem;
			request.setAttribute("mensagem", mensagem);
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			
			/*if(aluno.getFalta()==0)
			{
				msg.append("O campo de nota está vazio!");
				return false;
			}
			if(aluno.getMatricula().isEmpty())
			{
				msg.append("O campo de matricula está vazio!");
				return false;
			}
			if(aluno.getNota()==0)
			{
				msg.append("O campo de nota está vazio!");
				return false;
			}
			if(aluno.getPeriodo().isEmpty())
			{
				msg.append("O campo de periodo está vazio!");
				return false;
			}*/
		}
		catch(Exception ex)
		{
			mensagem.append(ex.getMessage());
		}
}
/*
		a.setNome(request.getParameter("nome"));
		a.setMatricula(request.getParameter("matricula"));
		a.setPeriodo(request.getParameter("periodo"));
		a.setFalta(Integer.parseInt(request.getParameter("falta")));
		a.setNota(Integer.parseInt(request.getParameter("nota")));
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
	*/
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		AlunoApplication jsa = new AlunoApplication();
		List<Aluno> cl = new ArrayList<Aluno>();
		String mensagem = "";
		/*try
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
		rd.forward(request, response);*/
		request.setAttribute("alunos", cl);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
}
