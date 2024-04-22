/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utils;

import jakarta.servlet.http.Cookie;

/**
 *
 * @author Sun
 */
public class CookieUtil {
    
    public static String getCookieValue(Cookie[] cookies, String cookieName){
        String cookieValue ="";
        Cookie cookie;
        if (cookies != null)
        {
            for(int i =0; i< cookies.length; i++)
            {
                cookie = cookies[i];
                if(cookieName.equals(cookie.getName()))
                {
                    cookieValue = cookie.getValue();
                }
            }
        }
        return cookieValue;
    }
    
}
            
                
