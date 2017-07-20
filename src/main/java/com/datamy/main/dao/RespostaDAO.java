/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.dao;

import com.datamy.main.bean.Chamado;
import com.datamy.main.bean.Resposta;
import com.datamy.main.connection.connectionFactory.ConexaoPGDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class RespostaDAO extends ConexaoPGDao {

    public ArrayList<Resposta> select() {
        Resposta resposta = null;
        ArrayList<Resposta> respostas = new ArrayList<Resposta>();
        CriarConexao();

        try {

            preparacao = conexao.prepareStatement("SELECT * FROM resposta");
            resultado = preparacao.executeQuery();

            while (resultado.next()) {
                respostas.add(new Resposta(resultado.getInt("id"), resultado.getString("texto")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }

        return respostas;
    }

    public Resposta select(int id) {
        Resposta resposta = null;

        CriarConexao();

        try {

            preparacao = conexao.prepareStatement("SELECT texto FROM resposta WHERE id=?");
            preparacao.setInt(1, id);
            resultado = preparacao.executeQuery();

            while (resultado.next()) {
                resposta = new Resposta(resultado.getInt("id"), resultado.getString("titulo"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }

        return resposta;
    }
}
