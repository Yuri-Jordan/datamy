/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.bean;

/**
 *
 * @author pablo
 */
public class RBean {
    private String token;
    private String url;
    private String pagina;

    public RBean() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public RBean(String token, String url, String pagina) {
        this.token = token;
        this.url = url;
        this.pagina = pagina;
    }
    
}
