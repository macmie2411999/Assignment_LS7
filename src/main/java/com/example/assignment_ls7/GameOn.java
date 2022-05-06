package com.example.assignment_ls7;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/gameon")
public class GameOn extends HttpServlet {
    Integer selectedNumber = createRandomNumber();
    Integer guessWork = 0;
    Integer timeOfGuesses = 0;
    String guessedNumbers = " None";
    String hints = " From 0 to 1000";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("timeOfGuesses", timeOfGuesses);
        request.setAttribute("guessedNumbers", guessedNumbers);
        request.setAttribute("hints", hints);

        RequestDispatcher dispatcher = request.getRequestDispatcher("gameon.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
//        System.out.println(request.getParameter("guessWork"));
        guessWork = Integer.parseInt(request.getParameter("guessWork"));
        if (guessWork < selectedNumber) {
            hints = "Designated Number Is Bigger Than ";
        } else if (guessWork > selectedNumber) {
            hints = "Designated Number Is Smaller Than ";
        } else {
            response.sendRedirect(request.getContextPath() + "/congratulation");
        }

        timeOfGuesses++;
        guessedNumbers += guessWork;
        request.setAttribute("timeOfGuesses", timeOfGuesses);
        request.setAttribute("guessedNumbers", guessedNumbers);
        request.setAttribute("hints", hints + guessWork);
    }

    public Integer createRandomNumber() {
        Integer min = 1;
        Integer max = 1000;
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
