<%--
  Created by IntelliJ IDEA.
  User: macmie
  Date: 05/05/2022
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="gameon.css">
    <title>Game On</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
</head>

<body>
<div class="container">
    <h3>I am Thinking of a number Between 1-1000.</h3>
    <h3>Can you Guess it </h3>
    <input type="text" placeholder="Number" id="guessWork" name="guessWork"><br>

    <form action="<%= request.getContextPath() %>/gameon" method="post">
        <button id="guessButton" name="button" value="okay">GUESS</button>
    </form>

    <p id="timeOfGuesses" name="timeOfGuesses">Times of Guessing: <%= request.getAttribute("timeOfGuesses")%></p>
    <p id="showGuessedNumbers" name="showGuessedNumbers">Guessed number: <%= request.getAttribute("guessedNumbers")%></p>
    <p id="showHints" name="showHints">Hint: <%= request.getAttribute("hints")%></p>
    </br>
    <form action="http://localhost:8080/welcome" method="get">
        <button class="btn btn-out btn-square continue" name="button" value="okay">Exit</button>
    </form>
</div>
</body>
</html>
