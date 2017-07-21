/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.bean;

import java.io.Serializable;

/**
 *
 * @author pablo
 */
public class Resposta implements Serializable{
    private static final long serialVersionUID = 1L;
    int id;
    String textoResposta;

    public Resposta() {
    }

    public Resposta(int id, String textoResposta) {
        this.id = id;
        this.textoResposta = textoResposta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextoResposta() {
        return textoResposta;
    }

    public void setTextoResposta(String textoResposta) {
        this.textoResposta = textoResposta;
    }
        
}
