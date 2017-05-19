

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ExecutarDois {

    public ExecutarDois() throws Exception {comRMI();}

    private void comRMI() throws Exception {
        Registry reg = LocateRegistry.createRegistry(5577);
        IPesquisa buscador = new Pesquisa();
        IPesquisa iuc = (IPesquisa) reg.lookup("A1");

        buscador.addProximo(iuc);
        
        reg.rebind("A1", buscador);
        System.out.println("Objeto cadastrado.");
    }

    public static void main(String[] args) throws Exception {
        new ExecutarDois();
    }
}
