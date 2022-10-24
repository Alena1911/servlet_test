package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String name = request.getParameter("username");

        if (name == null || name.equals("")) {
            try {
                writer.println("<h1>Пожалуйста, вернитесь и введите имя</h1>");
            }finally {
                writer.close();
            }
        } else {
            request.setAttribute("name", name);
            request.getRequestDispatcher("hello.jsp").forward(request, response);
        }

    }
}
