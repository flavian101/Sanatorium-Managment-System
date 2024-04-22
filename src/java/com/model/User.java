package com.model;

import java.io.Serializable;

public class User  {
    private String m_username;
    private String m_password;
    private String m_specialization;

    public User()
    {
        
    }
    public User(String specialization, String userName, String password) {
        m_specialization = specialization;
        m_username = userName;
        m_password = password;
    }

    public String getM_username() {
        return m_username;
    }

    public void setM_username(String m_username) {
        this.m_username = m_username;
    }

    public String getM_specialization() {
        return m_specialization;
    }

    public void setM_specialization(String m_specialization) {
        this.m_specialization = m_specialization;
    }

    public String getPassword() {
        return m_password;
    }

    public void setPassword(String password) {
        this.m_password = password;
    }
    
    
}
