package Controllers.Login;

import DAO.DAOFactory;
import DAO.Interfaces.AdminDao;
import Helper.Utile;
import Models.Admin;
import Models.Centre;
import Models.Donnateur;

import javax.rmi.CORBA.Util;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginAdmin")
public class LoginAdmin extends HttpServlet {

    private DAOFactory daoFactory;
    private AdminDao adminDao;
    private Admin admin;

    private String flashMessageFaild="";


    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        adminDao = daoFactory.getAdminDaoImpl();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println(email+" "+Utile.stringToSha256(password));
        admin = adminDao.getAdmin(email, Utile.stringToSha256(password));

        if (admin == null) {
            flashMessageFaild = "Invalid informations";
            request.setAttribute("flashMessageFaild", flashMessageFaild);
            this.getServletContext().getRequestDispatcher("/jsp/admin/LoginAdmin.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("admin", admin);
            response.sendRedirect("/dashboard");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if((Admin)session.getAttribute("admin") == null && (Centre)session.getAttribute("centre") == null && (Donnateur)session.getAttribute("donnateur") == null)
            this.getServletContext().getRequestDispatcher("/jsp/admin/LoginAdmin.jsp").forward(request, response);
        else if((Admin)session.getAttribute("admin") != null){
            response.sendRedirect("/dashboard");
        }
        else{
            response.sendRedirect("/");
        }
    }
}
