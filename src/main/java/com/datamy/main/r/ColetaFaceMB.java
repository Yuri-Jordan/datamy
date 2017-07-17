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
 * @author Yuri
 */
@ManagedBean
@RequestScoped
public class ColetaFaceMB {

    private String token;
    private String page;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

   
    public ColetaFaceMB() {
    }
    
    public void coletar() throws REXPMismatchException{
        //new ColetaFace().coletar(this.token, this.page);
    }
}
