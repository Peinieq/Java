package DartGameFirst;

import java.util.logging.Logger;

public class DartGame {
    private static final Logger logger = Logger.getLogger(DartGame.class.getName());

    private int firstPlayerPoints = 501;
    private int secondPlayerPoints = 501;

    public void shoot(int value, int multiplicity, int player) {
        validate(value,multiplicity);
        if (player == 1) {
            firstPlayerPoints = countPoints(value, multiplicity, firstPlayerPoints);
            checkWin(firstPlayerPoints,"First");

        } else {
            secondPlayerPoints = countPoints(value, multiplicity, secondPlayerPoints);
            checkWin(secondPlayerPoints,"Second");
        }
    }

    private int countPoints(int value, int multiplicity, int points) {
        points =  points - value * multiplicity;
        if(points == 0 ){
            return 1000;
        }else if(points < 0){
            return points + value * multiplicity;
        }
        return points;
    }
    private void checkWin(int points,String player){
        if(points == 1000){
            logger.info(player + "won!");
            restartGame();
        }
    }
    private void validate(int value,int multiplicity)throws IllegalArgumentException{
        if(value > 20 && value != 50 && value != 25){
            Exception ex = new IllegalArgumentException("Value is invalid");
            logger.exiting(this.getClass().getName(), "Method: validate", ex);
        }
        if(multiplicity != 2 && multiplicity != 1 && multiplicity !=3){
            Exception ex = new IllegalArgumentException("Multiplicity is invalid");
            logger.exiting(this.getClass().getName(), "Method: validate", ex); }
    }
    private void restartGame(){
        logger.info("New Game");
        firstPlayerPoints = 501;
        secondPlayerPoints = 501;
    }

    public int getFirstPlayerPoints() {
        return firstPlayerPoints;
    }

    public int getSecondPlayerPoints() {
        return secondPlayerPoints;
    }

}
