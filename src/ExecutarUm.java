

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ExecutarUm {

    public ExecutarUm() throws Exception {
        executaComRMI();
    }

    private void executaComRMI() throws Exception {
        Registry rmiRegistry = LocateRegistry.getRegistry("192.168.107.210",
                12345);
        System.out.println("Conectando");
        br.com.fatesg.buscador.IBuscador iuc = (br.com.fatesg.buscador.IBuscador) rmiRegistry.lookup("G1");

        iuc.buscar("data");
    }

    public static void main(String[] args) throws Exception {
        new ExecutarUm();
    }
}
