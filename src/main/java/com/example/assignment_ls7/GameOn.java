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
//    Integer selectedNumber = createRandomNumber();
//    Integer guessWork = 0;
//    Integer timeOfGuesses = 0;
//    String guessedNumbers = " None";
//    String hints = " From 0 to 1000";

    Integer selectedNumber;
    Integer guessWork;
    Integer timeOfGuesses;
    String guessedNumbers;
    String hints;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        selectedNumber = createRandomNumber();
        guessWork = 0;
        timeOfGuesses = 0;
        guessedNumbers = " None";
        hints = " From 0 to 1000";

        request.setAttribute("timeOfGuesses", timeOfGuesses);
        request.setAttribute("guessedNumbers", guessedNumbers);
        request.setAttribute("hints", hints);

        RequestDispatcher dispatcher = request.getRequestDispatcher("gameon.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        if (request.getParameter("button").equals("okay")) {
            System.out.println("SN: " + selectedNumber);
            guessWork = Integer.parseInt(request.getParameter("guessWork"));
            System.out.println("GW: " + guessWork);
            if (guessWork.equals(selectedNumber)) {
                response.sendRedirect(request.getContextPath() + "/congratulation");
            } else {
                if (guessWork < selectedNumber) {
                    hints = "Guess Bigger!";
                } else {
                    hints = "Guess Smaller!";
                }

                timeOfGuesses++;
                guessedNumbers = "" + guessWork;
                request.setAttribute("timeOfGuesses", timeOfGuesses);
                request.setAttribute("guessedNumbers", guessedNumbers);
                request.setAttribute("hints", hints);

                RequestDispatcher dispatcher = request.getRequestDispatcher("gameon.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    public Integer createRandomNumber() {
        Integer min = 1;
        Integer max = 1000;
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
