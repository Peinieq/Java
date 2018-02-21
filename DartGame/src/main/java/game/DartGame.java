package game;

import domain.Player;

import java.util.logging.Logger;

public class DartGame {
    private static final Logger logger = Logger.getLogger(DartGame.class.getName());
    private static final int START_POINTS = 501;

    private Player firstPlayer;
    private Player secondPlayer;

    public static int getStartPoints() {
        return START_POINTS;
    }

    public DartGame(String firstPlayerName, String secondPlayerName) {
        firstPlayer = new Player(firstPlayerName);
        secondPlayer = new Player(secondPlayerName);
    }

    public int getFirstPlayerPoints() {
        return firstPlayer.getPoints();
    }

    public int getSecondPlayerPoints() {
        return secondPlayer.getPoints();
    }

    public String getFirstPlayerName() {
        return firstPlayer.getName();
    }

    public String getSecondPlayerName() {
        return secondPlayer.getName();
    }

    private Player shootAndGetWinnerIfExist(int value, int multiplicity, int playerTurn) {
        validate(value, multiplicity);
        checkPlayerTurn(value, multiplicity, playerTurn);
        return getWinnerIfExist();
    }

    public String shoot(int value, int multiplicity, int playerTurn) {
        Player player = shootAndGetWinnerIfExist(value, multiplicity, playerTurn);
        if (player != null) {
            restartGame();
            return player.getName() + " is won!";
        }
        return player.getName() + " have " + player.getPoints() + " points now.";
    }

    private void checkPlayerTurn(int value, int multiplicity, int playerTurn) {
        if(playerTurn == 1) {
            firstPlayer.setPoints(countPoints(value, multiplicity, firstPlayer.getPoints()));
        } else {
            secondPlayer.setPoints(countPoints(value, multiplicity, secondPlayer.getPoints()));
        }
    }

    private Player getWinnerIfExist() {
        if(firstPlayer.getPoints() == 1000) {
            return firstPlayer;
        }
        return secondPlayer;
    }

    private int countPoints(int value, int multiplicity, int points) {
        points = points - points * multiplicity;
        points = getThousandWhenZeroPoints(points);
        points = countPointsWhenNegativeValue(value, multiplicity, points);
        return points;
    }

    private int getThousandWhenZeroPoints(int points) {
        if (points == 0) {
            return 1000;
        }
        return points;
    }

    private int countPointsWhenNegativeValue(int value, int multiplicity, int points) {
        if (points < 0) {
            return points + value * multiplicity;
        }
        return points;
    }

    private void validate(int value,int multiplicity) throws IllegalArgumentException {
        validateValue(value);
        validateMultiplicity(multiplicity);
    }

    private void validateValue(int value) throws IllegalArgumentException {
        if (value > 20 && value != 50 && value != 25) {
            throw new IllegalArgumentException("Value is invalid.");
        }
    }

    private void validateMultiplicity(int multiplicity) throws IllegalArgumentException {
        if (multiplicity != 1 && multiplicity != 2 && multiplicity != 3) {
            throw new IllegalArgumentException("Multiplicity is invalid.");
        }
    }

    private boolean isWon(int points) {
        return points == 1000;
    }

    public void restartGame() {
        firstPlayer.setPoints(START_POINTS);
        secondPlayer.setPoints(START_POINTS);
    }

}
