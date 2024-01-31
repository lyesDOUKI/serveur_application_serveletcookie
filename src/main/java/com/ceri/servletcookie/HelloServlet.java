package com.ceri.servletcookie;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


public class HelloServlet extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //creation formulaire
        out.println("<html><body>");
        out.println("<form method='post' action=''>");
        out.println("<label for='nom'>Nom : </label>");
        out.println("<input type='text' name='nom' id='nom' />");
        out.println("<input type='submit' value='Envoyer' />");
    }

}