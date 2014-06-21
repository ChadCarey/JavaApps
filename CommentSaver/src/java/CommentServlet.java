/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author chad
 */
@WebServlet(urlPatterns = {"/CommentServlet"})
public class CommentServlet extends HttpServlet {

    //UserController userController;
    CommentSaver commentSaver;
    
    public CommentServlet() {
      //  userController = new UserController();
        commentSaver = new CommentSaver();
    }
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
        PrintWriter out = response.getWriter();
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String viewuser = (String) request.getParameter("viewuser");
        request.setAttribute("comments", commentSaver.getUserComments(viewuser));
        request.getRequestDispatcher("viewComments.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = (String)request.getSession().getAttribute("user");
        if(user == null) {
            System.err.println("You are not logged in, redirecting");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        //String pass = (String)request.getAttribute("pass");
        /*if(!userController.validLogin(user, pass)) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }*/
        String comment = request.getParameter("comment");
        if(comment.isEmpty()) {
            String message = "Your comment is a bit short";
            request.setAttribute("invalid", message);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
        commentSaver.add(user, comment);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}