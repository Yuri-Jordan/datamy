/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.managebean;

import com.datamy.main.bean.Chamado;
import com.datamy.main.bean.ComentarioFB;
import com.datamy.main.bean.RespostasBot;
import com.datamy.main.dao.ChamadoDao;
import com.datamy.main.dao.ComentarioFBDao;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author pablo
 */
@ManagedBean(name = "comentario")
@RequestScoped
public class ComentarioFBManagedBean implements Serializable{
    private static final long serialVersionUID = 1L;    
    
    private ComentarioFB cometario_fb;
    private ComentarioFBDao comantario_fb_dao;

    public ComentarioFBManagedBean() {
        this.comantario_fb_dao = new ComentarioFBDao();
        this.cometario_fb = new ComentarioFB();
    }   
    
    public ArrayList<ComentarioFB> listarComentariosRuins(){                        
        return comantario_fb_dao.selectRuins();
    }
    
    public ArrayList<ComentarioFB> listarComentariosNeutros(){                        
        return comantario_fb_dao.selectNeutros();
    }
    
    public ArrayList<ComentarioFB> listarComentariosBons(){                        
        return comantario_fb_dao.selectBons();
    }
    
    public ArrayList<RespostasBot> getRespostas(){
        return comantario_fb_dao.respostasAceitas();
    }
    
    public ArrayList<RespostasBot> getRespostasPendentes(){
        return comantario_fb_dao.aceitarResposta();
    }
    
    public void marcarVisto(ComentarioFB coment){
        coment.setVisto("TRUE");
        comantario_fb_dao.marcarVisto(coment);
    }
    
//    public void formularResposta(ComentarioFB coment){
//        try {
//        	comantario_fb_dao.formular(coment);
//        } catch (SQLException ex) {
//            Logger.getLogger(ComentarioFBManagedBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public ComentarioFB getCometario_fb() {
        return cometario_fb;
    }

    public void setCometario_fb(ComentarioFB cometario_fb) {
        this.cometario_fb = cometario_fb;
    }

    public ComentarioFBDao getComantario_fb_dao() {
        return comantario_fb_dao;
    }

    public void setComantario_fb_dao(ComentarioFBDao comantario_fb_dao) {
        this.comantario_fb_dao = comantario_fb_dao;
    }
}
