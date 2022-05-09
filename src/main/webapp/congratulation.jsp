<%--
  Created by IntelliJ IDEA.
  User: macmie
  Date: 05/05/2022
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Congratulation!</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="congratulation.css" rel="stylesheet">
</head>

<body>

<div class="container" id="myModal" role="dialog">
    <div class="modal-dialog">
        <div class="card">
            <div class="text-right cross"><i class="fa fa-times"></i></div>
            <div class="card-body text-center"><img src="https://img.icons8.com/bubbles/200/000000/trophy.png">
                <h4>CONGRATULATIONS <%= session.getAttribute("namePlayer") %>!</h4>
                <p>You've got the right number after <%= session.getAttribute("finalTimesOfGuessing") %> times!</p>
                <form action="http://localhost:8080/leaderboard" method="post">
                    <button class="btn btn-out btn-square continue" name="button" value="okay">Leader Board</button>
                </form>
<%--                <form action="" method="post">--%>
<%--                    <button class="btn btn-out btn-square continue" name="button" value="okay">Leader Board</button>--%>
<%--                </form>--%>
            </div>
        </div>
    </div>
</div>

</body>
</html>
