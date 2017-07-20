/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.managebean;

import com.datamy.main.bean.ComentarioFB;
import com.datamy.main.bean.Resposta;
import com.datamy.main.bean.RespostasBot;
import com.datamy.main.bean.Usuario;
import com.datamy.main.dao.ComentarioFBDao;
import com.datamy.main.dao.RDao;
import com.datamy.main.dao.RespostaDAO;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Conversation.Tag;
import com.restfb.types.FacebookType;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author pablo
 */
@ManagedBean(name = "comentario")
@RequestScoped
public class ComentarioFBManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private ComentarioFB comentario_fb;
    private ComentarioFBDao comentario_fb_dao;

    @ManagedProperty(value = "#{usuario.usuario}")
    private Usuario user;

    public ComentarioFBManagedBean() {
        this.comentario_fb_dao = new ComentarioFBDao();
        this.comentario_fb = new ComentarioFB();
        this.user = new Usuario();
    }

    public void responderComentario(String token, ComentarioFB coment, String msgID, String from, String msgComent, int id) {
        marcarVisto(coment);
        RDao rd = new RDao();
        token = rd.select().getToken();
        msgID = msgID + "/comments";
        Tag tag = new Tag();
        tag.setName(from);
        
        RespostaDAO rDao = new RespostaDAO();
        Resposta r = new Resposta();
        r = rDao.select(id);
        String resposta = r.getTextoResposta();

        FacebookClient fbCli = new DefaultFacebookClient(token);
        fbCli.publish(msgID, String.class, Parameter.with("message", tag.getName() + ", " + resposta));

        resposta = "";
    }

    public ArrayList<ComentarioFB> listarComentariosRuins() {
        ArrayList<ComentarioFB> comentariosRuins = new ArrayList<ComentarioFB>();
        comentariosRuins =  comentario_fb_dao.selectRuins();
        return formatarTexto(comentariosRuins);
    }

    public ArrayList<ComentarioFB> listarComentariosNeutros() {
        ArrayList<ComentarioFB> comentariosNeutros = new ArrayList<ComentarioFB>();
        comentariosNeutros = comentario_fb_dao.selectNeutros();
        return formatarTexto(comentariosNeutros);
    }

    public ArrayList<ComentarioFB> listarComentariosBons() {
        ArrayList<ComentarioFB> comentarios = new ArrayList<ComentarioFB>();
        comentarios = comentario_fb_dao.selectBons();                        
        return formatarTexto(comentarios);
    }
    
    public ArrayList<ComentarioFB> formatarTexto(ArrayList<ComentarioFB> listaComentarios){
        ArrayList<ComentarioFB> comentarios2 = new ArrayList<ComentarioFB>();
        
        for (ComentarioFB s : listaComentarios) {

            String v = new String(s.getCommentsMessage().getBytes(), Charset.forName("UTF-8"));
            String w = new String(s.getCommentsFromName().getBytes(), Charset.forName("UTF-8"));

            if (s.getPostMessage() != null) {
                String a = new String(s.getPostMessage().getBytes(), Charset.forName("UTF-8"));
                s.setPostMessage(a);
            }

            s.setCommentsMessage(v);
            s.setCommentsFromName(w);            
            
            comentarios2.add(s);
        }
        return comentarios2;
    }

    public ArrayList<RespostasBot> getRespostas() {
        return comentario_fb_dao.respostasAceitas();
    }

    public ArrayList<RespostasBot> getRespostasPendentes() {
        return comentario_fb_dao.aceitarResposta();
    }

    public String marcarVisto(ComentarioFB com) {
        comentario_fb_dao.marcarVisto(com);
        return "AnalisarComentariosBons.xhtml";
    }

    public ComentarioFB getComentario_fb() {
        return comentario_fb;
    }

    public void setComentario_fb(ComentarioFB comentario_fb) {
        this.comentario_fb = comentario_fb;
    }

    public ComentarioFBDao getComentario_fb_dao() {
        return comentario_fb_dao;
    }

    public void setComentario_fb_dao(ComentarioFBDao comentario_fb_dao) {
        this.comentario_fb_dao = comentario_fb_dao;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
