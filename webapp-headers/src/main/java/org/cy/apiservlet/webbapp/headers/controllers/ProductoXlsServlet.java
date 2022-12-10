package org.cy.apiservlet.webbapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.cy.apiservlet.webbapp.headers.models.Producto;
import org.cy.apiservlet.webbapp.headers.service.ProductoService;
import org.cy.apiservlet.webbapp.headers.service.ProductoServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({"/productos.xls", "/productos.html","/productos"}) // un servlet soporta varios maping
public class ProductoXlsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar();

        resp.setContentType("text/html;charset=UTF-8");

        String servletPath = req.getServletPath();
        boolean esXls = servletPath.endsWith(".xls");
        if (esXls){
            resp.setContentType("application/vnd.ms-excel");// para poder exportar a excel
            resp.setHeader("Content-Disposition","attachment;filename=productos.xls"); // cabecera para colocar nombre al archivo, también para forzar la descarga(que no aparezca la ventana para descargar el archivo excel)
        }
        try (PrintWriter out = resp.getWriter()) {

            if (!esXls) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("     <head>");
                out.println("        <meta charset=\"UTF-8\">");
                out.println("        <title>Listado de Productos</title>");
                out.println("      </head>");
                out.println("      <body>");
                out.println("          <h1>Listado de Productos!</h1>");
                out.println("<p><a href= \"" + req.getContextPath() + "/productlos.xls" + "\">exportar a xls</a></p>");
            }
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>id</th>");
            out.println("<th>nombre</th>");
            out.println("<th>tipo</th>");
            out.println("<th>precio</th>");
            out.println("</tr>");
            // por cada producto creamos una fila
            productos.forEach(p ->{
                out.println("<tr>");
                out.println("<td>"+p.getId()+"</td>");
                out.println("<td>"+p.getNombre()+"</td>");
                out.println("<td>"+p.getTipo()+"</td>");
                out.println("<td>"+p.getPrecio()+"</td>");
                out.println("</tr>");
            });
            out.println("</table>");
            if (!esXls) {
                out.println("       </body>");
                out.println("</html>");
            }
        }
        
    }
}
