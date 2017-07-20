/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.managebean;

import com.datamy.main.bean.ComentarioFB;
import com.datamy.main.bean.RespostasBot;
import com.datamy.main.bean.Usuario;
import com.datamy.main.dao.ComentarioFBDao;
import com.datamy.main.dao.RDao;
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

    public void responderComentario(String token, ComentarioFB coment, String msgID, String from, String msgComent) {
        marcarVisto(coment);
//token = "EAACEdEose0cBAPn7pXwOvAdEw8ZB6nX25T1Acub7Tymwrn5WBZCJlePovc7XoJQYq4toJL8wZBrZBdpJYPxdPYHAnMtzs9LQhcccZB5qHWGUd9d8JKLcT5pPBp5DImeAZCE8ZCKezmuXEeun5wVy88U9ZAWc86Mj4JONpggj0yVfhiokRJxafpvJPoI0hm3QbREiqasPS3CNnQZDZD";
        RDao rd = new RDao();
        token = rd.select().getToken();
        msgID = msgID + "/comments";
        Tag tag = new Tag();
        tag.setName(from);
        String m1, m2, m3;
        m1 = "Obrigado pela avaliação!";
        m2 = "Tentaremos ao maximo proporcionar os melhores produtos para nossos clientes!";
        if (msgComent.split(" ").length < 3) {
            m3 = m1;
        } else {
            m3 = m2;
        }

        FacebookClient fbCli = new DefaultFacebookClient(token);
        fbCli.publish(msgID, String.class, Parameter.with("message", tag.getName() + ", " + m3));

        m3 = "";
    }

    public ArrayList<ComentarioFB> listarComentariosRuins() {
        return comentario_fb_dao.selectRuins();
    }

    public ArrayList<ComentarioFB> listarComentariosNeutros() {
        return comentario_fb_dao.selectNeutros();
    }

    public ArrayList<ComentarioFB> listarComentariosBons() {  
        ArrayList<ComentarioFB> comentarios = new ArrayList<ComentarioFB>();
        ArrayList<ComentarioFB> comentarios2 = new ArrayList<ComentarioFB>();
        comentarios = comentario_fb_dao.selectBons();
        
        for (ComentarioFB s: comentarios){
            
            byte[] bytesv = s.getCommentsMessage().getBytes();
            String v = new String( bytesv, Charset.forName("UTF-8") );
            
            byte[] bytesw = s.getCommentsFromName().getBytes();
            String w = new String( bytesw, Charset.forName("UTF-8") );

//            byte[] bytes = s.getPostMessage().getBytes();
//            String x = new String( bytes, Charset.forName("UTF-8") );

            s.setCommentsMessage(v); 
            
            s.setCommentsFromName(w);

//            s.setPostMessage(x);

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

//    public void formularResposta(ComentarioFB coment){
//        try {
//        	comentario_fb_dao.formular(coment);
//        } catch (SQLException ex) {
//            Logger.getLogger(ComentarioFBManagedBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
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
