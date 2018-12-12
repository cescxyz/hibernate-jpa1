package com.hibernatejpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;


public class App {

	static String db_name = "mydb", db_collection = "mycollection";

	
    public static void main(String[] args){
        guardarUsuarios();

        List<Usuario> usuarios = UnidadPersistencia.getInstance().getEntityManager()
                .createQuery("SELECT u FROM Usuario u", Usuario.class)
                .getResultList();

        for(Usuario u : usuarios) {
        	System.out.println("Salida"+ u.toString());
        }
        
        //Prueba de mongoDB
        List<User> user_list = new ArrayList<User>();
                DBCollection coll = MongoFactory.getCollection(db_name, db_collection);
                // Fetching cursor object for iterating on the database records.
                DBCursor cursor = coll.find();  
                while(cursor.hasNext()) {           
                    DBObject dbObject = cursor.next();
                    User user = new User();
                    user.setId(dbObject.get("id").toString());
                    user.setName(dbObject.get("name").toString());
                    // Adding the user details to the list.
                    user_list.add(user);
                }
         for(User u:user_list) {
        	 System.out.println("Mongo Name: "+u.getName());
        	 
         }
        
    }

    public static void guardarUsuarios(){
        Usuario usuario = new Usuario();
        usuario.setId_usuario(3L);
        usuario.setContraseña("david");
        usuario.setCorreo("JoseBriones@gmail.com");
        usuario.setEdad(18);
        usuario.setFecha(new Date());
        usuario.setNombre_usuario("JoseBriones");

        UnidadPersistencia.getInstance().getEntityManager().getTransaction().begin();

        UnidadPersistencia.getInstance().getEntityManager().merge(usuario);

        UnidadPersistencia.getInstance().getEntityManager().getTransaction().commit();
    }
    
    
    
}
