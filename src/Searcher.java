
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public class Searcher implements br.com.fatesg.buscador.Buscador{
    
    List<Searcher> lista = new ArrayList<>();
    final String PATH = "C:\\Users\\Aluno\\Desktop\\Conteudo_Everton\\Atividade_RMI";
    

    @Override
    public File buscar(String string) throws RemoteException {
        File arquivo = buscar2(string);
        if (arquivo == null) {
            for (br.com.fatesg.buscador.Buscador b : lista) {
                arquivo = b.buscar(string);
                if (arquivo != null) 
                    return arquivo;
            }
        }
        return arquivo;
    }
    
    private File buscar2(String nomeDoDado) {
        try {
            File folder = new File(PATH);
            File files[] = folder.listFiles();
            for (File f: files) {
                FileReader fr = new FileReader(f.getAbsolutePath());
                BufferedReader br = new BufferedReader(fr);
                String linha = "";
                while ((linha = br.readLine()) != null) {
                    String[] dados;
                    dados = linha.split(";");
                    for (int j = 0; j < dados.length; j++) {
                        if (dados[j].equalsIgnoreCase(nomeDoDado))
                            return new File(f.getAbsolutePath());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
