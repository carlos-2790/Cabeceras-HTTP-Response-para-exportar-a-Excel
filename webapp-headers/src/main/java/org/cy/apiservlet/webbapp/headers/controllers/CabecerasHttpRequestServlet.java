package org.cy.apiservlet.webbapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cabeceras-request")
public class CabecerasHttpRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String metodoHttp = req.getMethod();
        String requestUri = req.getRequestURI();// devuelve desp del puerto y del localhost, nombre del proyecto con el mapin url del servlet
        String requestUrl = req.getRequestURL().toString(); //devuelve la url completa
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String ipCliente = req.getRemoteAddr();
        String ip = req.getLocalAddr();// obtenemos la IP
        int port = req.getLocalPort();// retorna el puerto
        String scheme = req.getScheme();
        String host = req.getHeader("host");
        String url = scheme+"://"+host+contextPath+servletPath; // ruta completa de la url
        String url2 = scheme+"://"+ip+":"+port+contextPath+servletPath; // ruta completa de la url con IP


        try (PrintWriter out = resp.getWriter()) {


            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("     <head>");
            out.println("        <meta charset=\"UTF-8\">");
            out.println("        <title>Cabeceras HTTP Request</title>");
            out.println("      </head>");
            out.println("      <body>");
            out.println("          <h1>Cabeceras HTTP Request!</h1>");
            out.println("<ul>");
            out.println("<li>metodo http: "+ metodoHttp+"</li>");
            out.println("<li>request uri: "+ requestUri+"</li>");
            out.println("<li>request url: "+ requestUrl+"</li>");
            out.println("<li>context Path: "+ contextPath+"</li>");
            out.println("<li>servlet Path: "+ servletPath+"</li>");
            out.println("<li>IP local: "+ ip+"</li>");
            out.println("<li>Puerto local: "+ port+"</li>");
            out.println("<li>Scheme: "+ scheme+"</li>");
            out.println("<li>Host: "+host+"</li>");
            out.println("<li>URL: "+url+"</li>");
            out.println("<li>URL2: "+url2+"</li>");
            out.println("<ul>");
            out.println("       </body>");
            out.println("</html>");
        }
    }
}
