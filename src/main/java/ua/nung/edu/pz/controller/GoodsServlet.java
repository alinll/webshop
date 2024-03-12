package ua.nung.edu.pz.controller;

import ua.nung.edu.pz.view.IndexView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GoodsServlet", urlPatterns = {"/goods/*"})
public class GoodsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String context = "<h2>Goods!</h2>\n";

        String body = IndexView.getInstance().getBody(
                IndexView.getInstance().getHeader(""),
                IndexView.getInstance().getFooter(""),
                context
        );

        out.println(IndexView.getInstance().getPage("Green Shop", body));
    }
}
