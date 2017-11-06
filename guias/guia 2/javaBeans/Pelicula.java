// Problema 2-Codificar un JavaBean llamado Pelicula que tenga las siguientes propiedades:
// Titulo ( lectura/escritura), Director ( lectura/escritura), y Año ( lectura/escritura)

import java.io.Serializable;
import java.util.*;

public class Viaje implements Serializable {
    private String titulo, director;
    private double anio;

    public Viaje() {
        titulo = null;
        director = null;
        anio = 0;
    }

    public void setTitulo(String orig) { titulo = orig; }
    public void setDirector(String dest) { director = dest; }
    public void setAnio(double cost) { anio = cost; }

    public String getTitulo() { return titulo; }
    public String getDirector() { return director; }
    public double getAnio() { return anio; }
}