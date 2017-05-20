

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ExecutarDois {

    public ExecutarDois() throws Exception {comRMI();}

    private void comRMI() throws Exception {
        Registry reg = LocateRegistry.createRegistry(12345);
        br.com.fatesg.buscador.IBuscador buscador = new Buscador();
        br.com.fatesg.buscador.IBuscador iuc = (br.com.fatesg.buscador.IBuscador) reg.lookup("A1");

//        buscador.addProximo(iuc);
        
        reg.rebind("G1", buscador);
        System.out.println("Objeto cadastrado.");
    }

    public static void main(String[] args) throws Exception {
        new ExecutarDois();
    }
}
