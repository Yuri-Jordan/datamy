
package com.datamy.main.r;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

import com.datamy.main.connection.connectionFactory.R;


public class HelloWorld {
    
    public String helloFulano(String nome) throws REXPMismatchException{
        
        try {
            RConnection con = new R().getRconexao();
            con.eval("source('C:/Users/yuri/Documents/Git"
                    + "/datamy/src/main/webapp/resources"
                    + "/R scripts/teste.R')");
            
            String result = con.eval("helloworld('"+ nome + "')").asString();
            con.close();
            return result;
        } catch (RserveException ex) {
            Logger.getLogger(HelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
