import java.rmi.*;

public class ApplicationRMI {
    public static void main(String[] args) throws Exception {
        ImplementationRMI imp = new ImplementationRMI();
        Naming.rebind("//localhost:1234/serv1", imp);
        System.out.println("Executing...");
    }
}