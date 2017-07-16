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
import java.io.Serializable;
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

    public ArrayList<ComentarioFB> listarComentariosRuins() {
        return comentario_fb_dao.selectRuins();
    }

    public ArrayList<ComentarioFB> listarComentariosNeutros() {
        return comentario_fb_dao.selectNeutros();
    }

    public ArrayList<ComentarioFB> listarComentariosBons() {
        return comentario_fb_dao.selectBons();
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
