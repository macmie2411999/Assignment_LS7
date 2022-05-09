package com.example.assignment_ls7;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

@WebServlet("/leaderboard")
public class LeaderBoard extends HttpServlet {
    ArrayList<Player> collectionPlayer = new ArrayList<Player>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("leaderboard.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String namePlayer = String.valueOf(request.getSession(false).getAttribute("namePlayer"));
        String resultGuessing = String.valueOf(request.getSession(false).getAttribute("finalTimesOfGuessing"));

        if(collectionPlayer.isEmpty()){
            Player newPlayer = new Player(namePlayer, resultGuessing);
            collectionPlayer.add(newPlayer);
            System.out.println(newPlayer.getNamePlayer());
            Collections.sort(collectionPlayer, Collections.reverseOrder());
            request.setAttribute("collectionPlayer", collectionPlayer);
        } else{
//            for(Player ele : collectionPlayer){
//                if (ele.getNamePlayer().equals(namePlayer) && ele.getTimesOfGuessing().equals(resultGuessing)){
//                    System.out.println("Result and player are already saved!");
//                } else{
                    Player newPlayer = new Player(namePlayer, resultGuessing);
                    collectionPlayer.add(newPlayer);
                    Comparator<Player> comparatorByNumberOfGuessing = Comparator
                            .comparing(Player::getTimesOfGuessing);
                    collectionPlayer.sort(comparatorByNumberOfGuessing);
                    request.setAttribute("collectionPlayer", collectionPlayer);
//                }
//            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("leaderboard.jsp");
        dispatcher.forward(request, response);
    }
}
