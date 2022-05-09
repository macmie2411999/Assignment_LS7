package com.example.assignment_ls7;

public class Player {
    private String namePlayer;
    private String timesOfGuessing;

    public Player() {
    }

    public Player(String namePlayer, String timesOfGuessing) {
        this.namePlayer = namePlayer;
        this.timesOfGuessing = timesOfGuessing;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public String getTimesOfGuessing() {
        return timesOfGuessing;
    }

    public void setTimesOfGuessing(String timesOfGuessing) {
        this.timesOfGuessing = timesOfGuessing;
    }
}
