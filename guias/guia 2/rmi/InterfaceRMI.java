
import java.rmi.*;

public interface InterfaceRMI extends Remote {

    public double triangleArea(double b, double h) throws RemoteException;
    public boolean isPointInsideCircle(double x, double y) throws RemoteException;

}
