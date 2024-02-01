package com.ceri.servletcookie;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


public class HelloServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //recuperation du cookie
        Cookie[] cookies = request.getCookies();
        String nom = null;
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("nom")){
                    nom = cookie.getValue();
                    break;
                }
            }
        }
        if(nom != null && !nom.isEmpty()){
            out.println("<h1>Bonjour via le cookies nom : " + nom + "</h1>");
        }
        //creation formulaire
        out.println("<html><body>");
        out.println("<form method='get' action='second-servlet'>");
        out.println("<label for='nom'>Nom : </label>");
        out.println("<input type='text' name='nom' id='nom' />");
        out.println("<input type='submit' value='Envoyer' />");
    }

}