/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.managebean;

import com.datamy.main.bean.RBean;
import com.datamy.main.dao.RDao;
import com.datamy.main.r.ColetaFace;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.rosuda.REngine.REXPMismatchException;

/**
 *
 * @author pablo
 */
@ManagedBean(name="r")
@SessionScoped
public class RManagedBean{
    private static final long serialVersionUID = 1L;
    private RDao rd;
    private RBean rb;
    
    public RManagedBean (){
        this.rb = new RBean();
        this.rd = new RDao();
    }
    
    public String salvarPaginaFB(){
        rd.insert(rb);
        return "home.xhtml";
    }

    public void coletar() throws REXPMismatchException{
        ColetaFace cf = new ColetaFace();
        cf.coletar();
    }
    public RBean getRb() {
        return rb;
    }

    public void setRb(RBean rb) {
        this.rb = rb;
    }
    
    
}
