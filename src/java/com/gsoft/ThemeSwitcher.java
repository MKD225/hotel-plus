/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsoft;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

/**
 *
 * @author vgladky
 */
@Named
@SessionScoped
public class ThemeSwitcher implements Serializable {

    private Map<String, String> themes;
    private String theme = "cupertino";

    public Map<String, String> getThemes() {
        return themes;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @PostConstruct
    public void init() {
        themes = new TreeMap<String, String>();
        themes.put("Aristo", "aristo");
        themes.put("Cupertino", "cupertino");
        themes.put("Humanity", "humanity");
        themes.put("Redmond", "redmond");
        themes.put("South-street", "south-street");
        themes.put("Start", "start");
        themes.put("Sunny", "sunny");
        themes.put("Black-tie", "black-tie");
        themes.put("ui-darkness", "ui-darkness");
        themes.put("ui-lightness", "ui-lightness");
    }
    public void saveTheme(ValueChangeEvent event) {
//        FacesContext context = FacesContext.getCurrentInstance();
//        context.addMessage(null, new FacesMessage("Ви успішно змінили тему", "Вітаємо "));
    }
}
