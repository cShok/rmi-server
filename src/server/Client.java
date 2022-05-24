package server;/* Chanany Shok
 Small client program running by RMI.
 */

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;

public class Client {

    public static void main(String[] args){

        try{
//          System.setProperty("java.rmi.server.hostname", args[0]);
            // Connect to the rmi registry, using the host name and the port
            Registry reg = LocateRegistry.getRegistry("192.168.146.1", 2020);
            System.out.println(Arrays.toString(reg.list()));

            // Look up the stub by name
            Prod p1 = (Prod) reg.lookup("myprod");

            // Using the stub to invoke the method remotely
            System.out.println(p1.getProd(p1));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
