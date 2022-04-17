/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author delga
 */
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean nuevoUsuario = true;
        
        // Extreaer cookies
        Cookie[] cookies = req.getCookies();
        
        if(cookies != null){
            for (Cookie c : cookies) {
                if(c.getName().equals("visitanteRecurrente") && c.getValue().equals("si")){
                    nuevoUsuario = false;
                    break;
                }
            }
        }
        
        
        String mensaje = null;
        if(nuevoUsuario){
            Cookie vistanteCookie = new Cookie("visitanteRecurrente", "si");
            resp.addCookie(vistanteCookie);
            mensaje = "Gracias por visitar nuestro sitio por primera vez";
        } else {
            mensaje = "Gracias por visitar nuestro sitio frecuentemente";
        }
        
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(mensaje);
        out.close();
        
    }
    
}
