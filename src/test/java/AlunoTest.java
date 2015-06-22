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
	@Test
	public void testaAlunoComNota90DeveSerAprovado()
	{
		AlunoApplication alunoApplication = new AlunoApplication();
		
		Aluno a = new Aluno();
		
		a.setNome("Leandro");
		a.setMatricula("34343");
		a.setFalta(12);
		a.setNota(90);
		a.setPeriodo("1/2015");
		
		boolean valido = alunoApplication.validar(a, new StringBuffer());
		
		assertEquals(valido, true);
	}
}