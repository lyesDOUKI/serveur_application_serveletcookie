package com.ceri.servletcookie;


import java.io.*;
import javax.servlet.http.*;
public class SecondServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        //recuperation du nom
        String nom = request.getParameter("nom");
        if(nom == null || nom.isEmpty()){
            nom = "inconnu";
            //suppression cookie
            //recuperation des cookies et mettre à 0 la durée de vie
            Cookie[] cookies = request.getCookies();
            if(cookies != null){
                for(Cookie cookie : cookies){
                    if(cookie.getName().equals("nom")){
                        cookie.setMaxAge(0); // mettre à 0 pour
                        // le supprimer du navigateur
                        response.addCookie(cookie);
                        break;
                    }
                }
            }
        }else {
            Cookie cookie = new Cookie("nom", nom);
            response.addCookie(cookie);
        }
        //ajout cookie

        response.setContentType("text/html");
        out.println("<html><body>");
        out.println("<h1>Bonjour " + nom + "</h1>");
        out.println("<a href='hello-servlet'>Retour à helloServlet</a>");
        out.println("<br><a href='second-servlet?nom="
                + nom + "'>Réafficher la page</a>");
        out.println("</body></html>");
    }
}
