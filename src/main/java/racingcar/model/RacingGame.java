package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    
    private static List<String> carNames = new ArrayList<String>();
    private static List<String> countResult = new ArrayList<String>();
    private static int gameChance;
    private static int randomNumber;

    public void setCarNames(List<String> carNames){
        RacingGame.carNames = carNames;
    }

    public void setCountResult(List<String> countResult){
        RacingGame.countResult = countResult;
    }

    public void setGameChance(int gameChance){
        RacingGame.gameChance = gameChance;
    }

    public void setrandomNumber(int randomNumber){
        RacingGame.randomNumber = randomNumber;
    }

    public List<String> getCarNames(){
        return carNames;
    }

    public List<String> getCountResult(){
        return countResult;
    }

    public int getGameChance(){
        return gameChance;
    }

    public int getRandomNumber(){
        return randomNumber;
    }

    public int getCarNumbers(){
        return carNames.size();
    }
}
