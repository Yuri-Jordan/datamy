package com.datamy.main.connection.connectionFactory;

import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class R {

    RConnection rcon = null;

    public RConnection getRconexao(){
        try {
        /* Create a connection to Rserve instance running on default port
         * 6311
         */
        rcon = new RConnection("localhost", 6311);
        return rcon;
        
        }catch (RserveException e) {
            e.printStackTrace();
        }
            return null;
    }
    
//    public boolean closeConexao(RConnection con) {return con.close();}
}
