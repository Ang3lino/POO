
import java.rmi.*;

public interface InterfaceRMI extends Remote {

    public double triangleArea(double b, double h) throws RemoteException;
    public boolean isPointInsideCircle(double x, double y) throws RemoteException;
    public double employeeSalary(double hr, double extra) throws RemoteException;
    public String upper(String s) throws RemoteException;
    public long length(String s) throws RemoteException;
    public int max(int n[]) throws RemoteException;
    public int min(int n[]) throws RemoteException;
    public double average(int n[]) throws RemoteException;

}
