/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sovcombank.fotoreport;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bulgakovdg
 */
@WebServlet(name = "SaveFotoServlet", urlPatterns = {"/SaveFotoServlet"})
public class SaveFotoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SaveFotoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SaveFotoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        try {
            
            String fileName = "D:/programming/newphoto.png";         
            String urlPic = request.getParameter("UrlPicture");
            String base64Image = urlPic.split(",")[1];
            byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
            
            BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));
            
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            ImageIO.write(img, "png", file);
            
    		response.getWriter().append("Served at: ").append(request.getContextPath());
    		PrintWriter out = response.getWriter();
    		out.println("<b>znak = ghf</b>");
    		out.close();
        } catch (Exception e) {
            
    		response.getWriter().append("Served at: ").append(request.getContextPath());
    		PrintWriter out = response.getWriter();
    		out.println("<b>ERRO1" + e.toString() + "</b>");
    		out.close();
        }

    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
}

}
