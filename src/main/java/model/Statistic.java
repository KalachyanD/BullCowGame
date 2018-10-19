package model;

public class Statistic {
    String login;
    Integer games;
    Integer attemptsInGame;

    public Statistic(String login, Integer games, Integer attempts) {
        this.login = login;
        this.games = games;
        if (games == 0) {
            attemptsInGame = 0;
        } else {
            this.attemptsInGame = attempts / games;
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getGames() {
        return games;
    }

    public void setGames(Integer games) {
        this.games = games;
    }

    public Integer getAttemptsInGame() {
        return attemptsInGame;
    }

    public void setAttemptsInGame(Integer attemptsInGame) {
        this.attemptsInGame = attemptsInGame;
    }
}
