package com.hibernatejpa;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Table(name = "Usuario")
@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private long id_usuario;

    @Column(name = "nombre_usuario", unique = true)
    private String nombre_usuario;

    @Column(name = "contraseña")
    private String contraseña;

    @Column(name = "edad")
    private int edad;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha = new Date();

    @Column(name = "correo")
    private String correo;

    public Usuario() {
    }

    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + id_usuario +
                ", nombre_usuario='" + nombre_usuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", edad=" + edad +
                ", fecha=" + new SimpleDateFormat().format(fecha) +
                ", correo='" + correo + '\'' +
                '}';
    }
}
