/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.r;

import com.datamy.main.bean.RBean;
import com.datamy.main.connection.connectionFactory.R;
import com.datamy.main.dao.RDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

/**
 *
 * @author Yuri
 */
public class ColetaFace {
     public void coletar() throws REXPMismatchException{
        
        try {
            //instancia da classe de acesso aos dados da pagina cadastrada no banco
            //atribuição dos valores resgatados do banco pra realizar a consulta com r
            //na rede social
            
            RDao rdao = new RDao();            
            RBean rb = rdao.select();
            String token = rb.getToken();
            String url = rb.getUrl();
            
            RConnection con = new R().getRconexao();
            con.eval("source('C:/Users/pablo/OneDrive/Documentos/NetBeansProjects/datamy/datamy/src/main/webapp/resources/R scripts/main.R')");
            
            con.eval("main('" + token + "','" + url + "')");
            con.close();
            
        } catch (RserveException ex) {
            Logger.getLogger(HelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
