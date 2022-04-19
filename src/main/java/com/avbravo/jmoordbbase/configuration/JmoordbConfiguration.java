/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbbase.configuration;

import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import java.util.Map;
import lombok.Data;

/**
 *
 * @author avbravo
 */
@Data
public class JmoordbConfiguration {

    Boolean revisionSave;
    String username;
    Boolean spanish;
    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    Map<String, Object> sessionMap = externalContext.getSessionMap();

    public JmoordbConfiguration() {
    }

    public JmoordbConfiguration(Boolean revisionSave, String username, Boolean spanish) {

        this.revisionSave = revisionSave;
        this.username = username;
        this.spanish = spanish;
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        sessionMap.put("username", username);
        sessionMap.put("revisionSave", revisionSave);
        sessionMap.put("spanish", spanish);
    }

  

   

    public Boolean getRevisionSave() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        Boolean revisionSave = (Boolean) sessionMap.get("revisionSave");
        return revisionSave;
    }

    /*
    Para que devuelva el del contexto
     */
    public String getUsername() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        String username = (String) sessionMap.get("username");
        return username;
    }

    public Boolean getSpanish() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        Boolean spanish = (Boolean) sessionMap.get("spanish");
        return spanish;
    }

  

    public void setRevisionSave(Boolean revisionSave) {
        this.revisionSave = revisionSave;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSpanish(Boolean spanish) {
        this.spanish = spanish;
    }

    public ExternalContext getExternalContext() {
        return externalContext;
    }

    public void setExternalContext(ExternalContext externalContext) {
        this.externalContext = externalContext;
    }

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

   
    public static class Builder {

   
        Boolean revisionSave;
        String username;
        Boolean spanish;

       

      
        public Builder withRevisionSave(Boolean revisionSave) {
            this.revisionSave = revisionSave;
            return this;
        }

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withSpanish(Boolean spanish) {
            this.spanish = spanish;
            return this;
        }

        public JmoordbConfiguration build() {
            return new JmoordbConfiguration(revisionSave, username, spanish);
        }

    }

}
