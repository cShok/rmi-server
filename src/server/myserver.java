/* Chanany Shok
    The main server program.
    Bootstrap the rmi server and the rmi registry.
 */
package server;


import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

public class myserver extends UnicastRemoteObject {
    protected myserver() throws RemoteException {
        super();
    }

    public static void main(String [] args ){
        
        try{
            
            // setting the host name
            System.setProperty("java.rmi.server.hostname", "192.168.146.1");
            System.out.println("Server up");
            
            //creating instance of object on server side.
            ProdImp exmp = new ProdImp("hi");

            //export the object
            Prod stubProd = (Prod)UnicastRemoteObject.exportObject(exmp, 0);

            //initialize the registry
            Registry reg1 = LocateRegistry.createRegistry(2020);

            // bindind the stub to a name later to be calle dby client
            reg1.bind("myprod", stubProd);
            System.out.println("Registry running, names of objects are \n");
            System.out.println(Arrays.toString(reg1.list()));

        } catch (RemoteException | AlreadyBoundException e) {
            System.out.println("server error\n");
            e.printStackTrace();
        }
    }
}
