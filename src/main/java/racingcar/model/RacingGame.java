package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    
    private List<Object> carNames = new ArrayList<Object>();
    private List<String> countResult = new ArrayList<String>();
    private int gameChance;
    private int randomNumber;

    public void setCarNames(List<Object> carNames){
        this.carNames = carNames;
    }

    public void setCountResult(List<String> countResult){
        this.countResult = countResult;
    }

    public void setGameChance(int gameChance){
        this.gameChance = gameChance;
    }

    public void setrandomNumber(int randomNumber){
        this.randomNumber = randomNumber;
    }

    public List<Object> getCarNames(){
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
}
