/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.r;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.rosuda.REngine.REXPMismatchException;

/**
 *
 * @author yuri
 */
@ManagedBean
@RequestScoped
public class teste {

    private String nome;
    private String mensg;
    
    public teste() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMensg() {
        return mensg;
    }

    public void setMensg(String mensg) {
        this.mensg = mensg;
    }

  
    
    public void hello() throws REXPMismatchException{
         this.mensg = new HelloWorld().helloFulano(this.nome);
    }
}
