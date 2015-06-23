import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.bson.types.ObjectId;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import com.controller.*;

public class AlunoTest
{
	/*@Test
	public void testDescricao() 
	{
		AlunoServlet sv = new AlunoServlet();
		Aluno a = new Aluno();
		String erroQueDeveAcontecer = "b";
		String erroRetornado = "b";
		assertEquals("c", erroQueDeveAcontecer, erroRetornado);
	}*/
	//testes com notas -------------------------------------------------------------------
	@Test
	public void testAlunoComNota90DeveSerAprovadoRecebeHomenagem()
	{
		AlunoApplication alunoApplication = new AlunoApplication();
		
		Aluno a = new Aluno();
		
		a.setNome("Leandro");
		a.setMatricula("34343");
		a.setFalta(12);
		a.setNota(92);
		a.setPeriodo("1/2015");
		
		boolean valido = alunoApplication.validar(a, new StringBuffer());
		
		assertEquals(true, valido);
	}
	@Test
	public void testAlunoComNota50FazProvaEspecial()
	{
		AlunoApplication alunoApplication = new AlunoApplication();
		
		Aluno a = new Aluno();
		
		a.setNome("Leandro");
		a.setMatricula("34343");
		a.setFalta(12);
		a.setNota(50);
		a.setPeriodo("1/2015");
		
		boolean valido = alunoApplication.validar(a, new StringBuffer());
		
		assertEquals(true, valido);
	}
	@Test
	public void testAlunoComNota60AprovadoNotaMinimaFaltasMenorQue20()
	{
		AlunoApplication alunoApplication = new AlunoApplication();
		
		Aluno a = new Aluno();
		
		a.setNome("Leandro");
		a.setMatricula("34343");
		a.setFalta(1);
		a.setNota(60);
		a.setPeriodo("1/2015");
		
		boolean valido = alunoApplication.validar(a, new StringBuffer());
		
		assertEquals(true, valido);
	}
	@Test
	public void testAlunoComNota60ReprovadoNotaMinimaFaltasMaiorQue20()
	{
		AlunoApplication alunoApplication = new AlunoApplication();
		
		Aluno a = new Aluno();
		
		a.setNome("Leandro");
		a.setMatricula("34343");
		a.setFalta(21);
		a.setNota(60);
		a.setPeriodo("1/2015");
		
		boolean valido = alunoApplication.validar(a, new StringBuffer());
		
		assertEquals(false, valido);
	}
	@Test
	public void testAlunoComNotaMenorQue50Reprovado()
	{
		AlunoApplication alunoApplication = new AlunoApplication();
		
		Aluno a = new Aluno();
		
		a.setNome("Leandro");
		a.setMatricula("34343");
		a.setFalta(1);
		a.setNota(48);
		a.setPeriodo("1/2015");
		
		boolean valido = alunoApplication.validar(a, new StringBuffer());
		
		assertEquals(false, valido);
	}
	//----------testes como nome --------------------------------------------------------------------------------
	@Test
	public void testAlunoComNomeVazio()
	{
		AlunoApplication alunoApplication = new AlunoApplication();
		
		Aluno a = new Aluno();
		
		a.setNome("");
		a.setMatricula("34343");
		a.setFalta(1);
		a.setNota(48);
		a.setPeriodo("1/2015");
		
		boolean valido = alunoApplication.validar(a, new StringBuffer());
		
		assertEquals(false, valido);
	}
	
	@Test
	public void testAlunoComEspacamentoAntesDoNome()
	{
		AlunoApplication alunoApplication = new AlunoApplication();
		
		Aluno a = new Aluno();
		
		a.setNome(" ");
		a.setMatricula("34343");
		a.setFalta(1);
		a.setNota(48);
		a.setPeriodo("1/2015");
		
		boolean valido = alunoApplication.validar(a, new StringBuffer());
		
		assertEquals(false, valido);
	}
	//testes matricula -------------------------------------------------------------------------------
	@Test
	public void testMatriculaVazia()
	{
		AlunoApplication alunoApplication = new AlunoApplication();
		
		Aluno a = new Aluno();
		
		a.setNome("Adao");
		a.setMatricula("");
		a.setFalta(1);
		a.setNota(48);
		a.setPeriodo("1/2015");
		
		boolean valido = alunoApplication.validar(a, new StringBuffer());
		
		assertEquals(false, valido);
	}
	//teste aluno faltas ----------------------------------------------------------------------------
	@Test
	public void testAlunoMaximo20FaltasAprovado()
	{
		AlunoApplication alunoApplication = new AlunoApplication();
		
		Aluno a = new Aluno();
		
		a.setNome("Joao");
		a.setMatricula("34343");
		a.setFalta(20);
		a.setNota(70);
		a.setPeriodo("1/2015");
		
		boolean valido = alunoApplication.validar(a, new StringBuffer());
		
		assertEquals(true, valido);
	}
	//teste periodo -----------------------------------------------------------------------------
	@Test
	public void testPeriodoVazio()
	{
		AlunoApplication alunoApplication = new AlunoApplication();
		
		Aluno a = new Aluno();
		
		a.setNome("Adao");
		a.setMatricula("2323");
		a.setFalta(1);
		a.setNota(48);
		a.setPeriodo("");
		
		boolean valido = alunoApplication.validar(a, new StringBuffer());
		
		assertEquals(false, valido);
	}
}