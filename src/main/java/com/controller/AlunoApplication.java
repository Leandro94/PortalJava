package com.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;
public class AlunoApplication
{
	/*public StringBuffer create(Aluno a)
	{
		
	}*/
	
	public StringBuffer create(Aluno a)
    {
		StringBuffer mensagem = new StringBuffer();
    	try
    	{
    		if(validar(a, mensagem))
    		{
    			 MongoClientURI uri  = new MongoClientURI("mongodb://portaljava:portaljava@ds047742.mongolab.com:47742/portaljava"); 
    	            MongoClient mongo = new MongoClient(uri);
    	            DB db = mongo.getDB("portaljava");
    	            DBCollection col = db.getCollection("portaljava");
    		        
    		        //create user
    		        BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
    		        ObjectId id = new ObjectId();
    		        docBuilder.add("_id", id);
    		        docBuilder.append("nome", a.getNome());
    		        docBuilder.append("nota", a.getNota());
    		        docBuilder.append("falta", a.getFalta());
    		        docBuilder.append("periodo", a.getPeriodo());
    		        docBuilder.append("matricula", a.getMatricula());
    		        DBObject doc = docBuilder.get();
    		        WriteResult result = col.insert(doc);
    		        System.out.println(result.getUpsertedId());
    		        System.out.println(result.getN());
    		        System.out.println(result.isUpdateOfExisting());
    		        System.out.println(result.getLastConcern());
    		        a.set_id(id);
    		        mongo.close();
    		}
           
    	}
    	catch(Exception ex)
    	{
    		mensagem.append(ex.getMessage());
    	}
    	return mensagem;
    }
	
	public List<Aluno> todos() throws Exception
    {
		try
		{
			MongoClientURI uri  = new MongoClientURI("mongodb://portaljava:portaljava@ds047742.mongolab.com:47742/portaljava"); 
	        MongoClient mongo = new MongoClient(uri);
	        DB db = mongo.getDB("portaljava");
	        DBCollection col = db.getCollection("portaljava");
	        //read example	
	        DBCursor cursor = col.find();
	        List<Aluno> alunos = new ArrayList<Aluno>();
	        while(cursor.hasNext())
	        {
	    		Gson gson = new Gson();
	    		DBObject current = cursor.next();
	    		Aluno j = gson.fromJson(current.toString(), Aluno.class);
	            alunos.add(j);
	        }
	        //close resources
	        mongo.close();
	    	return alunos;
		}
        catch(Exception e)
		{
        	return null;
		}
    }
	
	public boolean validar(Aluno aluno,StringBuffer msg)
	{
		
		if(aluno.getNome().isEmpty())
		{
			msg.append("O campo de nome esta vazio!");
			return false;
		}
		if(aluno.getNome().equals(" "))
		{
			msg.append("O campo de nome possui um espacamento no inicio!");
			return false;
		}
		//--------------------------------------------------------------------------------
		if(aluno.getFalta()<=20 && aluno.getNota()>=60)
		{
			msg.append("O aluno foi aprovado com um numero de faltas permitdo!");
			return true;
		}
		//-------------------------------------------------------------------------------
		if(aluno.getMatricula().isEmpty())
		{
			msg.append("O campo de matricula esta vazio!");
			return false;
		}
		//----------------------------------------------------------------------
		if(aluno.getNota()>=50 && aluno.getNota()<=59)
		{
			msg.append("O aluno ira fazer prova especial!");
			return true;
		}
		if(aluno.getNota()>=90)
		{
			msg.append("O aluno ira receber uma homenagem por brilhar!");
			return true;
		}
		if(aluno.getNota()<50)
		{
			msg.append("O aluno esta reprovado!");
			return false;
		}
		if(aluno.getNota()==60 && aluno.getFalta()<20)
		{
			msg.append("O aluno passou com nota minima e as faltas sao aceitas!");
			return true;
		}
		if(aluno.getNota()==60 && aluno.getFalta()>20)
		{
			msg.append("O aluno reprovou por faltas embora tenha nota minima!");
			return false;
		}
		//-----------------------------------------------------------------------------------------------
		if(aluno.getPeriodo().isEmpty())
		{
			msg.append("O campo de periodo esta vazio!");
			return false;
		}
			msg = null;
			return true;
		
		
	}
}
