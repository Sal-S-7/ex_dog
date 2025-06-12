package com.example.ex_chien.servlet;

import com.example.ex_chien.dao.DogDao;
import com.example.ex_chien.entity.Dog;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/dog")
public class DogController extends HttpServlet {
    private final DogDao dogDao = new DogDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("add".equals(action)) {
            req.getRequestDispatcher("/jsp/addDog.jsp").forward(req, resp);
        } else if ("detail".equals(action)) {
            Long id = Long.valueOf(req.getParameter("id"));
            Dog dog = dogDao.findById(id);
            req.setAttribute("dog", dog);
            req.getRequestDispatcher("/jsp/detailDog.jsp").forward(req, resp);
        } else {
            List<Dog> dogs = dogDao.findAll();
            req.setAttribute("dogs", dogs);
            req.getRequestDispatcher("/jsp/listDog.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));

        Dog dog = new Dog(name, breed, birthDate);
        dogDao.save(dog);

        resp.sendRedirect(req.getContextPath() + "/dog");
    }
}
