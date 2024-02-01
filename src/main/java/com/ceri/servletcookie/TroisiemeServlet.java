package com.ceri.servletcookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TroisiemeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //recuperation du nom depuis le cookies
        String nom = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("nom")){
                    nom = cookie.getValue();
                    break;
                }
            }
        }
        if(nom == null || nom.isEmpty()){
            nom = "inconnu, aucun cookies";
        }
        //affichage
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Bonjour troisieme servlet : " + nom + "</h1>");

    }
}
