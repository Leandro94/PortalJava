package com.controller;
import java.util.ArrayList;
import java.util.List;

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
	public String create(Aluno j)
    {
    	String mensagem = null;
    	try
    	{
            MongoClientURI uri  = new MongoClientURI("mongodb://nodejsportalacademico:leandro@ds047792.mongolab.com:47792/nodejsportalacademico"); 
            MongoClient mongo = new MongoClient(uri);
            DB db = mongo.getDB("alunos");
	        DBCollection col = db.getCollection("alunos");
	        
	        //create user
	        BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
	        ObjectId id = new ObjectId();
	        docBuilder.add("_id", id);
	        docBuilder.append("nome", j.getNome());
	        docBuilder.append("nota", j.getNota());
	        docBuilder.append("falta", j.getFalta());
	        docBuilder.append("periodo", j.getPeriodo());
	        docBuilder.append("matricula", j.getMatricula());
	        DBObject doc = docBuilder.get();
	        WriteResult result = col.insert(doc);
	        System.out.println(result.getUpsertedId());
	        System.out.println(result.getN());
	        System.out.println(result.isUpdateOfExisting());
	        System.out.println(result.getLastConcern());
	        j.set_id(id);
	        mongo.close();
    	}
    	catch(Exception ex)
    	{
    		mensagem = ex.getMessage();
    	}
    	return mensagem;
    }
	
	public List<Aluno> todos() throws Exception
    {
        MongoClientURI uri  = new MongoClientURI("mongodb://nodejsportalacademico:leandro@ds047792.mongolab.com:47792/nodejsportalacademico"); 
        MongoClient mongo = new MongoClient(uri);
        DB db = mongo.getDB("alunos");
        DBCollection col = db.getCollection("alunos");
        //read example
        DBCursor cursor = col.find();
        List<Aluno> jetskies = new ArrayList<Aluno>();
        while(cursor.hasNext())
        {
    		Gson gson = new Gson();
    		DBObject current = cursor.next();
    		Aluno j = gson.fromJson(current.toString(), Aluno.class);
            jetskies.add(j);
        }
        //close resources
        mongo.close();
    	return jetskies;
    }
	
	public String validar(String nome, String nota, String periodo, String falta, String matricula)
	{
		String mensagem = null;
		try
		{
			Integer.parseInt(falta);
			Integer.parseInt(nota);
		}
		catch(Exception ex)
		{
			mensagem = ex.getMessage();
		}
		if(nome.length() < 10)
			mensagem = "Sua descrição deve conter 10 caracteres";
		return mensagem;
	}
}
