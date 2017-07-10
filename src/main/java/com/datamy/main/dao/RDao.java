/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.dao;

import com.datamy.main.bean.RBean;
import com.datamy.main.connection.connectionFactory.ConexaoPGDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class RDao extends ConexaoPGDao{
    private ArrayList<RBean> dadosPagina = new ArrayList<RBean>(); 
    
    public void insert(RBean rbean){
        CriarConexao();
        try {
            
            preparacao = conexao.prepareStatement("INSERT INTO `cartaocredito`(`token`, `url`, `pagina`) VALUES (?,?,?)");
            preparacao.setString(1, rbean.getToken());
            preparacao.setString(2, rbean.getUrl());
            preparacao.setString(3, rbean.getPagina());
            preparacao.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(RDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
    }
    
    public RBean select(int id){
        RBean rbean = null;                
        CriarConexao();
        
        try {
            
            preparacao = conexao.prepareStatement("SELECT * FROM chamado WHERE id=?");
            preparacao.setInt(1, id);            
            resultado = preparacao.executeQuery();                        
            
            while(resultado.next()){                
                dadosPagina.add(new RBean(resultado.getString("token"), resultado.getString("url"),resultado.getString("pagina")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
                        
        return rbean;
    }
}
