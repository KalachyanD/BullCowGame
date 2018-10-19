package model;

public class User {
    String login;
    String password;
    Integer games;
    Integer attempts;

    public User(String login, String password, Integer games, Integer attempts) {
        this.login = login;
        this.password = password;
        this.games = games;
        this.attempts = attempts;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGames() {
        return games;
    }

    public void setGames(Integer games) {
        this.games = games;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }
}
