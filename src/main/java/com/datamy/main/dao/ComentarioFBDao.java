/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.dao;

import com.datamy.main.bean.ComentarioFB;
import com.datamy.main.bean.RespostasBot;
import com.datamy.main.connection.connectionFactory.ConexaoPGDao;
import java.nio.charset.Charset;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class ComentarioFBDao extends ConexaoPGDao {

    ArrayList<ComentarioFB> comentarios_fb;
    ComentarioFB cmt;

    public ComentarioFBDao() {
        super();
    }

    public ComentarioFB select(int id) {
        ComentarioFB comentario_fb = null;

        CriarConexao();

        try {

            preparacao = conexao.prepareStatement("SELECT * FROM novo WHERE post.id = ?");
            //preparacao.setString(1, coment.getId());
            resultado = preparacao.executeQuery();

            while (resultado.next()) {
                comentarios_fb.add(new ComentarioFB(
                        resultado.getString("row.names"),
                        resultado.getString("post.from_id"),
                        resultado.getString("post.from_name"),
                        resultado.getString("post.message"),
                        resultado.getString("post.created_time"),
                        resultado.getString("post.type"),
                        resultado.getString("post.link"),
                        resultado.getString("post.id"),
                        resultado.getString("post.likes_count"),
                        resultado.getString("post.comments_count"),
                        resultado.getString("post.shares_count"),
                        //resultado.getString("likes.from_name"),
                        //                        resultado.getString("likes_from_id"),
                        resultado.getString("comments.from_id"),
                        resultado.getString("comments.from_name"),
                        resultado.getString("comments.message"),
                        resultado.getString("comments.created_time"),
                        resultado.getString("comments.likes_count"),
                        resultado.getString("comments.comments_count"),
                        resultado.getString("comments.id"),
                        resultado.getString("avaliacao"),
                        resultado.getString("visto")
                ));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ComentarioFBDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }

        return comentario_fb;
    }

    public ArrayList<ComentarioFB> selectRuins() {
        ArrayList<ComentarioFB> comentarios_fb_ruins = new ArrayList<ComentarioFB>();
        parametrizar(resultado, comentarios_fb_ruins, "negative");
        return comentarios_fb_ruins;
    }

    public ArrayList<ComentarioFB> selectNeutros() {
        ArrayList<ComentarioFB> comentarios_fb_neutros = new ArrayList<ComentarioFB>();        
        parametrizar(resultado, comentarios_fb_neutros, "neutral");
        return comentarios_fb_neutros;
    }

    public ArrayList<ComentarioFB> selectBons() {
        ArrayList<ComentarioFB> comentarios_fb_positivos = new ArrayList<ComentarioFB>();
        parametrizar(resultado, comentarios_fb_positivos, "positive");
        return comentarios_fb_positivos;
    }

    public ArrayList<RespostasBot> aceitarResposta() {
        ArrayList<RespostasBot> comments = new ArrayList<RespostasBot>();
        CriarConexao();
        try {

            resultado = consulta.executeQuery("SELECT * FROM bot_respostas WHERE aceita = FALSE");
            while (resultado.next()) {
                comments.add(new RespostasBot(resultado.getInt("id"),
                        resultado.getBoolean("aceita"),
                        resultado.getString("bot_resposta_texto")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ComentarioFBDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
        return comments;
    }

    public ArrayList<RespostasBot> respostasAceitas() {
        ArrayList<RespostasBot> comments = new ArrayList<RespostasBot>();
        CriarConexao();
        try {

            resultado = consulta.executeQuery("SELECT bot_resposta_textoo FROM bot_respostas WHERE aceita = TRUE");
            while (resultado.next()) {
                comments.add(new RespostasBot(resultado.getInt("id"), resultado.getBoolean("aceita"), resultado.getString("bot_resposta_texto")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ComentarioFBDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
        return comments;
    }

//    public String formular(ComentarioFB coment) throws SQLException {        
//        String stmt = "UPDATE teste_json2 SET message='Resposta automatica' WHERE id = ?";
//        preparacao.setString(1, coment.getId());
//        try {            
//            consulta.executeUpdate(stmt);
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(ComentarioFBDao.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            fecharConexao();            
//        }  
//        return null;
//    }
    public void marcarVisto(ComentarioFB id) {
        CriarConexao();
        try {
            String sql = "UPDATE novo SET visto=true WHERE \"comments.id\"=?";

            preparacao = conexao.prepareStatement(sql);
            preparacao.setString(1, id.getCommentsId());
            preparacao.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ComentarioFBDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
    }

    public void parametrizar(ResultSet rs, ArrayList<ComentarioFB> lista, String avaliacao) {
        CriarConexao();

        try {
            rs = consulta.executeQuery("SELECT * FROM novo WHERE avaliacao = '"+avaliacao+"' AND visto = 'false'");
//            System.out.println("QUERY  "+rs);
            while (rs.next()) {
                lista.add(new ComentarioFB(
                        rs.getString("row.names"),
                        rs.getString("from_id"),
                        rs.getString("from_name"),
                        rs.getString("message"),
                        rs.getString("created_time"),
                        rs.getString("type"),
                        rs.getString("link"),
                        rs.getString("id"),
                        rs.getString("likes_count"),
                        rs.getString("comments_count"),
                        rs.getString("shares_count"),
                        //resultado.getString("likes.from_name"),
                        //                        resultado.getString("likes.from_id"),
                        rs.getString("from_id.1"),
                        rs.getString("from_name.1"),
                        rs.getString("message.1"),
                        rs.getString("created_time.1"),
                        rs.getString("likes_count.1"),
                        rs.getString("comments_count.1"),
                        rs.getString("id.1"),
                        rs.getString("avaliacao"),
                        rs.getString("visto")
                ));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ComentarioFBDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
    }
}
