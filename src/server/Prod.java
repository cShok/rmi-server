/* Chanany Shok
    Interface implementing rmi's remote library.
 */

package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

    public interface Prod extends Remote {
        int getProd(Prod p) throws RemoteException;
    }


