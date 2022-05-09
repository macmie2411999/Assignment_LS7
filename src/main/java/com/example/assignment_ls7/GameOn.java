package com.example.assignment_ls7;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        // save name of player
        String namePlayer = request.getParameter("namePlayer");
        HttpSession session = request.getSession();
        session.setAttribute("namePlayer", namePlayer);
        session.setMaxInactiveInterval(100000);

        // set default values
        selectedNumber = createRandomNumber();
        guessWork = 0;
        timeOfGuesses = 0;
        guessedNumbers = " None";
        hints = " From 0 to 1000";

        System.out.println("The Selected Number Is: " + selectedNumber);

        request.setAttribute("timeOfGuesses", timeOfGuesses);
        request.setAttribute("guessedNumbers", guessedNumbers);
        request.setAttribute("hints", hints);

        // forward
        RequestDispatcher dispatcher = request.getRequestDispatcher("gameon.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // check if button is clicked
        if (request.getParameter("button").equals("okay")) {
            System.out.println("The Selected Number Is: " + selectedNumber);
            guessWork = Integer.parseInt(request.getParameter("guessWork"));
            if (guessWork.equals(selectedNumber)) {

                //create and save result of player
                String finalTimesOfGuessing = ++timeOfGuesses + "";
                HttpSession session = request.getSession();
                session.setAttribute("finalTimesOfGuessing", finalTimesOfGuessing);
                session.setMaxInactiveInterval(100000);

                // redirect to Congratulation page if player guess correctly
                response.sendRedirect(request.getContextPath() + "/congratulation");
            } else {
                if (guessWork < selectedNumber) {
                    hints = "Guess Bigger!";
                } else {
                    hints = "Guess Smaller!";
                }

                // show result if players guess wrongly
                timeOfGuesses++;
                guessedNumbers = "" + guessWork;
                request.setAttribute("timeOfGuesses", timeOfGuesses);
                request.setAttribute("guessedNumbers", guessedNumbers);
                request.setAttribute("hints", hints);

                // forward
                RequestDispatcher dispatcher = request.getRequestDispatcher("gameon.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    // create a random number
    public Integer createRandomNumber() {
        Integer min = 1;
        Integer max = 1000;
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
