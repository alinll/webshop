package ua.nung.edu.pz.controller;

import ua.nung.edu.pz.view.MainPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CartServlet", urlPatterns = {"/cart/*"})
public class CartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String context = "<h2>Cart!</h2>\n";

        String builderPage = MainPage.Builder.newInstance()
                .setTitle("Green Shop")
                .setHeader("")
                .setBody(context)
                .setFooter()
                .build()
                .getFullPage();

        out.println(builderPage);
    }
}