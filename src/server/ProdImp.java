/* Chanany Shok
    Class implementing the Prod remote class.
 */

package server;

import java.io.Serializable;
import java.rmi.RemoteException;

public class ProdImp implements Prod, Serializable {

    //vars
    String name;

    // Constructor
    public ProdImp(String name) throws RemoteException{
        this.name = name;
    }

    @Override
    // Showcase the proxy name
    public int getProd(Prod p) throws RemoteException {
        int len = 0;
        Class<? extends Prod> holder = p.getClass();
        System.out.println(holder);
        for(int i = 0; i < holder.getName().length() ; i++)
            len++;
        return len;
    }
}
