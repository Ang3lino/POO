
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

    public double employeeSalary(double hr, double extra) throws RemoteException {
        final double minSal = 70;
        return minSal * (hr + 2 * extra);
    }

    public String upper(String s) throws RemoteException {
        return s.toUpperCase();
    }

    public long length(String s) throws RemoteException {
        return s.length();
    }

    public int max(int n[]) throws RemoteException {
        Arrays.sort(n);
        return n[n.length - 1];
    }

    public int min(int n[]) throws RemoteException {
        Arrays.sort(n);
        return n[0];
    }

    public double average(int n[]) throws RemoteException {
        double sum = 0;
        for (int i = 0; i < n.length; i++)
            sum += n[i];
        return sum / n.length;
    }
}
