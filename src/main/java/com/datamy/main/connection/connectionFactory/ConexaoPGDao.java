/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.connection.connectionFactory;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class ConexaoPGDao implements Serializable{
    private static final long serialVersionUID = 1L;                    
    
    protected static final String JDBC_DRIVER = "org.postgresql.Driver";
    protected static final String BANCO = "jdbc:postgresql://localhost:5432/datamy";
    
    protected static final String USER = "postgres";
    protected static final String PASS = "12345";
    
    protected Statement consulta;
    protected ResultSet resultado;
    protected PreparedStatement preparacao;
    protected Connection conexao;

    protected void CriarConexao() {
        try {
            Class.forName("org.postgresql.Driver");                       
            conexao = DriverManager.getConnection(BANCO, USER, PASS);            
            consulta = conexao.createStatement();
            

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoPGDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoPGDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    protected void fecharConexao(){
        try {            
            conexao.close();            
            fecharPreparedStatement();
            fecharResultSet();
            fecharStatement();
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoPGDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fecharStatement(){
        if(consulta != null){
            try {
                consulta.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoPGDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void fecharPreparedStatement(){
        if(preparacao != null){
            try {
                preparacao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoPGDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void fecharResultSet(){
        if(resultado != null){
            try {
                resultado.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoPGDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
