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
	/*public StringBuffer create(Aluno a)
	{
		
	}*/
	
	public StringBuffer create(Aluno a)
    {
		StringBuffer mensagem = new StringBuffer();
    	try
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
    	catch(Exception ex)
    	{
    		mensagem.append(ex.getMessage());
    	}
    	return mensagem;
    }
	
	public List<Aluno> todos() throws Exception
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
	
	public boolean validar(Aluno aluno,StringBuffer msg)
	{
		
		if(aluno.getNome().isEmpty())
		{
			msg.append("O campo de nome está vazio!");
			return false;
		}
		if(aluno.getFalta()==0)
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
		}
		msg = null;
		return true;
	}
}
