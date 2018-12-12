package com.hibernatejpa;

import java.util.Date;
import java.util.List;

public class App {

    public static void main(String[] args){
        guardarUsuarios();

        List<Usuario> usuarios = UnidadPersistencia.getInstance().getEntityManager()
                .createQuery("SELECT u FROM Usuario u", Usuario.class)
                .getResultList();

        for(Usuario u : usuarios) {
        	System.out.println("Salida"+ u.toString());
        }
        
        guardarUsuarios();
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
