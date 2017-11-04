
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class ImplementationRMI extends UnicastRemoteObject implements InterfaceRMI {
    private static final long serialVersionUID = 1L;

    protected ImplementationRMI() throws RemoteException {
        super();
    }
    
    public double triangleArea(double b, double h) throws RemoteException {
        return b * h / 2;
    }

    public boolean isPointInsideCircle(double x, double y) throws RemoteException {
        return Math.sqrt(x * x + y * y) <= 100;
    }
    
}
