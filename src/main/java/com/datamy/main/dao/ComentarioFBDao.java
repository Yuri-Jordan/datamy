/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.dao;

import com.datamy.main.bean.ComentarioFB;
import com.datamy.main.bean.RespostasBot;
import com.datamy.main.connection.connectionFactory.ConexaoPGDao;
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

            preparacao = conexao.prepareStatement("SELECT * FROM comentario_fb_avaliados WHERE post.id = ?");
            //preparacao.setString(1, coment.getId());
            resultado = preparacao.executeQuery();

            while (resultado.next()) {
                comentarios_fb.add(new ComentarioFB(
                        resultado.getString("row_names"),
                        resultado.getString("post_from_id"),
                        resultado.getString("post_from_name"),
                        resultado.getString("post_message"),
                        resultado.getString("post_created_time"),
                        resultado.getString("post_type"),
                        resultado.getString("post_link"),
                        resultado.getString("post_id"),
                        resultado.getString("post_likes_count"),
                        resultado.getString("post_comments_count"),
                        resultado.getString("post_shares_count"),
                        resultado.getString("likes_from_name"),
                        resultado.getString("likes_from_id"),
                        resultado.getString("comments_from_id"),
                        resultado.getString("comments_from_name"),
                        resultado.getString("comments_message"),
                        resultado.getString("comments_created_time"),
                        resultado.getString("comments_likes_count"),
                        resultado.getString("comments_comments_count"),
                        resultado.getString("comments_id"),
                        resultado.getString("avaliacao"),
                        resultado.getBoolean("visto")
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
        ArrayList<ComentarioFB> comentarios_fb_lista = new ArrayList<ComentarioFB>();
        CriarConexao();

        try {
            resultado = consulta.executeQuery("SELECT * FROM comentario_fb_avaliados WHERE avaliacao = 'negative' AND visto = FALSE");
            while (resultado.next()) {
                comentarios_fb_lista.add(new ComentarioFB(
                        resultado.getString("row_names"),
                        resultado.getString("post_from_id"),
                        resultado.getString("post_from_name"),
                        resultado.getString("post_message"),
                        resultado.getString("post_created_time"),
                        resultado.getString("post_type"),
                        resultado.getString("post_link"),
                        resultado.getString("post_id"),
                        resultado.getString("post_likes_count"),
                        resultado.getString("post_comments_count"),
                        resultado.getString("post_shares_count"),
                        resultado.getString("likes_from_name"),
                        resultado.getString("likes_from_id"),
                        resultado.getString("comments_from_id"),
                        resultado.getString("comments_from_name"),
                        resultado.getString("comments_message"),
                        resultado.getString("comments_created_time"),
                        resultado.getString("comments_likes_count"),
                        resultado.getString("comments_comments_count"),
                        resultado.getString("comments_id"),
                        resultado.getString("avaliacao"),
                        resultado.getBoolean("visto")
                ));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ComentarioFBDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }

        return comentarios_fb_lista;
    }

    public ArrayList<ComentarioFB> selectNeutros() {
        ArrayList<ComentarioFB> comentarios_fb_lista = new ArrayList<ComentarioFB>();
        CriarConexao();

        try {
            resultado = consulta.executeQuery("SELECT * FROM comentario_fb_avaliados WHERE avaliacao = 'neutral' AND visto = FALSE");
            while (resultado.next()) {
                comentarios_fb_lista.add(new ComentarioFB(
                        resultado.getString("row_names"),
                        resultado.getString("post_from_id"),
                        resultado.getString("post_from_name"),
                        resultado.getString("post_message"),
                        resultado.getString("post_created_time"),
                        resultado.getString("post_type"),
                        resultado.getString("post_link"),
                        resultado.getString("post_id"),
                        resultado.getString("post_likes_count"),
                        resultado.getString("post_comments_count"),
                        resultado.getString("post_shares_count"),
                        resultado.getString("likes_from_name"),
                        resultado.getString("likes_from_id"),
                        resultado.getString("comments_from_id"),
                        resultado.getString("comments_from_name"),
                        resultado.getString("comments_message"),
                        resultado.getString("comments_created_time"),
                        resultado.getString("comments_likes_count"),
                        resultado.getString("comments_comments_count"),
                        resultado.getString("comments_id"),
                        resultado.getString("avaliacao"),
                        resultado.getBoolean("visto")
                ));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ComentarioFBDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }

        return comentarios_fb_lista;
    }

    public ArrayList<ComentarioFB> selectBons() {
        ArrayList<ComentarioFB> comentarios_fb_lista = new ArrayList<ComentarioFB>();
        CriarConexao();

        try {
            resultado = consulta.executeQuery("SELECT * FROM comentario_fb_avaliados WHERE avaliacao = 'positive' AND visto = FALSE");
            while (resultado.next()) {
                comentarios_fb_lista.add(new ComentarioFB(
                        resultado.getString("row_names"),
                        resultado.getString("post_from_id"),
                        resultado.getString("post_from_name"),
                        resultado.getString("post_message"),
                        resultado.getString("post_created_time"),
                        resultado.getString("post_type"),
                        resultado.getString("post_link"),
                        resultado.getString("post_id"),
                        resultado.getString("post_likes_count"),
                        resultado.getString("post_comments_count"),
                        resultado.getString("post_shares_count"),
                        resultado.getString("likes_from_name"),
                        resultado.getString("likes_from_id"),
                        resultado.getString("comments_from_id"),
                        resultado.getString("comments_from_name"),
                        resultado.getString("comments_message"),
                        resultado.getString("comments_created_time"),
                        resultado.getString("comments_likes_count"),
                        resultado.getString("comments_comments_count"),
                        resultado.getString("comments_id"),
                        resultado.getString("avaliacao"),
                        resultado.getBoolean("visto")
                ));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ComentarioFBDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }

        return comentarios_fb_lista;
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
    public void marcarVisto(ComentarioFB coment) {
        CriarConexao();
        try {
            String sql = "UPDATE comentario_fb_avaliados SET post_from_id=?,post_from_name=?,post_message=?,"
                    + "post_created_time=?, post_type=?, post_link=?, "
                    + "post_id=?, post_likes_count=?, post_comments_count=?,"
                    + "post_shares_count=?, likes_from_name=?, likes_from_id=?, "
                    + "comments_from_id=?, comments_from_name=?, "
                    + "comments_message=?, comments_created_time=?, "
                    + "comments_likes_count=?, comments_comments_count=?, comments_id=?, avaliacao=?, "
                    + "visto=? WHERE 'row_names'=?";

            preparacao = conexao.prepareStatement(sql);
            preparacao.setString(1, coment.getPostFromId());
            preparacao.setString(2, coment.getPostFromName());
            preparacao.setString(3, coment.getPostMessage());
            preparacao.setString(4, coment.getPostCreatedTime());
            preparacao.setString(5, coment.getPostType());
            preparacao.setString(6, coment.getPostLink());
            preparacao.setString(7, coment.getPostId());
            preparacao.setString(8, coment.getPostLikesCount());
            preparacao.setString(9, coment.getPostCommentsCount());
            preparacao.setString(10, coment.getPostSharesCount());
            preparacao.setString(11, coment.getLikesFromName());
            preparacao.setString(12, coment.getLikesFromId());
            preparacao.setString(13, coment.getCommentsFromId());
            preparacao.setString(14, coment.getCommentsFromName());
            preparacao.setString(15, coment.getCommentsMessage());
            preparacao.setString(16, coment.getCommentsCreatedTime());
            preparacao.setString(17, coment.getCommentsLikesCount());
            preparacao.setString(18, coment.getCommentsCommentsCount());
            preparacao.setString(19, coment.getCommentsId());
            preparacao.setString(20, coment.getAvaliacao());
            preparacao.setBoolean(21, true);
            preparacao.setString(22, coment.getRowNames());

            preparacao.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
    }
}
