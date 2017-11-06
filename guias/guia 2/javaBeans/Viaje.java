// Problema 1-Codificar un JavaBean llamado Viaje que tenga las siguientes propiedades:
// Origen ( lectura/escritura), Destino ( lectura/escritura), y Costo ( lectura/escritura)

import java.io.Serializable;
import java.util.*;

public class Viaje implements Serializable {
    private String origen, destino;
    private double costo;

    public Viaje() {
        origen = null;
        destino = null;
        costo = 0;
    }

    public void setOrigen(String orig) { origen = orig; }
    public void setDestino(String dest) { destino = dest; }
    public void setCosto(double cost) { costo = cost; }

    public String getOrigen() { return origen; }
    public String getDestino() { return destino; }
    public double getCosto() { return costo; }

}