/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.managebean;

import com.datamy.main.dao.RespostaDAO;
import com.datamy.main.bean.Resposta;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author pablo
 */
@ManagedBean(name = "resposta", eager = true)
@SessionScoped
public class RespostaBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Resposta resposta;
    private RespostaDAO respostaDao;
    private ArrayList<Resposta> respostas;

    public RespostaBean() {        
        this.resposta = new Resposta();
        this.respostaDao = new RespostaDAO();
    }
    
    public ArrayList<Resposta> select(){       
        return respostaDao.select();
    }

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }

    public RespostaDAO getRespostaDao() {
        return respostaDao;
    }

    public void setRespostaDao(RespostaDAO respostaDao) {
        this.respostaDao = respostaDao;
    }

    public ArrayList<Resposta> getRespostas() {
        ArrayList<Resposta> resps = select();
        for(Resposta r : resps){
            respostas.add(r);
        }
        return respostas;
    }

    public void setRespostas(ArrayList<Resposta> respostas) {
        this.respostas = respostas;
    }        
    
}
