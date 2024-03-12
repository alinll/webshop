package ua.nung.edu.pz.controller;

import ua.nung.edu.pz.model.Firebase;
import ua.nung.edu.pz.model.User;
import ua.nung.edu.pz.view.ContactView;
import ua.nung.edu.pz.view.IndexView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet(name = "StartServlet", urlPatterns = {"/*"}, loadOnStartup = 1)
public class StartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String body = "";
        String context = "";

        switch (request.getPathInfo()) {
            case "/contacts":
                context = "<h2>Our Contacts!</h2>\n";
                break;
            case "/login":
                context = "<h2>Login!</h2>\n";
                context += IndexView.getInstance().getLoginForm();
                break;
            case "/forgotpassword":
                context = "<h2>Restore Password!</h2>\n";
                break;
            default:
                context = "<h2>Hello World from Servlet!</h2>\n";
        }


        body = IndexView.getInstance().getBody(
                IndexView.getInstance().getHeader(""),
                IndexView.getInstance().getFooter(""),
                context);

        out.println(IndexView.getInstance().getPage("Green Shop", body));

        User user = new User();
        user.setEmail("email@email.com");
        user.setPassword("112211221122");
        user.setDisplayName("Test User");
        Firebase firebase = Firebase.getInstance();
        if (firebase.getUserByEmail(user.getEmail()) != "OK"){
            // TODO alina: login user
            System.out.println("User Exist");
        }
        else {
            //String userMsg = Firebase.getInstance().createUser(user);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contextPath = request.getContextPath();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        System.out.println(user);

        response.sendRedirect("/");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        String path = getServletContext().getRealPath("/html/");
        IndexView indexView = IndexView.getInstance();
        indexView.setPath(path);

        String[] firebaseConfig = readFirebaseConfig();
        Firebase.getInstance().setFirebaseConfigPath(firebaseConfig[0]);
        Firebase.getInstance().setFirebaseName(firebaseConfig[1]);
        Firebase.getInstance().init();
    }

    private String[] readFirebaseConfig() {
        Properties props = new Properties();
        String[] firebasrProp = new String[2];
        InputStream is = getClass().getClassLoader().getResourceAsStream("app.properties");
        try {
            props.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        firebasrProp[0] = props.getProperty("file.path");
        firebasrProp[1] = props.getProperty("firebase.name");
        return firebasrProp;
    }
}
