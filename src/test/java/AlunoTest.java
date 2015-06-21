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
	@Test
	public void testDescricao() {
		AlunoServlet sv = new AlunoServlet();
		Aluno j = new Aluno(null, "Leandro", 10, 1, "1/2015", "120027365");
		String erroQueDeveAcontecer = "O nome do aluno deve ter no mínimo 10 caracteres.";
		String erroRetornado = "O nome do aluno deve ter no mínimo 10 caracteres.";
		assertEquals("São iguais", erroQueDeveAcontecer, erroRetornado);
	}
}