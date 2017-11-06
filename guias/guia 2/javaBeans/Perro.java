/* Problema 3.-Codificar un JavaBean llamado Perro que tenga las siguientes propiedades:
   Nombre ( lectura/escritura), Raza ( lectura/escritura), Edad ( lectura/escritura), 
   Dueño ( lectura/escritura) , Genero  ( lectura/escritura), y AñosRestantesDeVida ( solo lectura). 
   Suponga que si la raza es:
   
   Pastor Aleman el perro vive 15  años
   Boxer el perro vive 11 años
   Terrier el perro vive 8 años,
   Doberman el perro vive 13 años
   para las otras razas vive 14 años */

import java.io.Serializable;
import java.util.*;

public class Perro implements Serializable{
    private String nombre, raza, duenio, genero;
    private double edad, aniosRestantes, espVida;

    public Perro() {
        nombre = null;
        raza = null;
        duenio = null;
        genero = null;
        edad = 0;
        aniosRestantes = 0;
    }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setRaza(String raza) { 
        this.raza = raza; 
        switch (raza) {
            case "Pasto Aleman": espVida = 15; break;
            case "Boxer": espVida = 11; break;
            case "Terrier": espVida = 8; break;
            case "Doberman": espVida = 13; break;
            default: espVida = 14; break;
        }
    }

    public void setDuenio(String duenio) { this.duenio = duenio; }
    public void setGenero(String genero) { this.genero = genero; }

    public void setEdad(double edad) { 
        (edad >= 0) ? this.edad = edad : 
            throw new ArithmeticException("Edad negativa... ");
    }

    public String getNombre() { return nombre; }
    public String getRaza() { return raza; }
    public String getDuenio() { return duenio; }
    public String getGenero() { return genero; }

    public double getEdad() { return edad; }
    public double getAniosRestantes() { 
        return espVida - edad;
    }

}