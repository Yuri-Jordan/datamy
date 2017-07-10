package com.datamy.main.r;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

import com.datamy.main.connection.connectionFactory.R;
import com.datamy.main.dao.RDao;


public class HelloWorld {
    //adição do parametro id pra pegar um registro do banco relativo a uma pagina especifica
    public String helloFulano(String nome, int id) throws REXPMismatchException{
        
        try {
            //instancia da classe de acesso aos dados da pagina cadastrada no banco
            //atribuição dos valores resgatados do banco pra realizar a consulta com r
            //na rede social
            RDao rdao = new RDao();            
            String token = rdao.select(id).getToken();
            String url = rdao.select(id).getUrl();
            String pagina = rdao.select(id).getPagina();
            RConnection con = new R().getRconexao();
            con.eval("source('C:/Users/yuri/Documents/Git"
                    + "/datamy/src/main/webapp/resources"
                    + "/R scripts/teste.R')").asString();
            
            String result = con.eval("helloworld('"+ nome + "')").asString();
            con.close();
            return result;
        } catch (RserveException ex) {
            Logger.getLogger(HelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
