package racingcar.domain;

import racingcar.Constants;
import racingcar.utils.Utils;

public class Car {
   private final String name;
   private int position = 0;


    public Car(String name) {
        this.name = name;
    }

    public void moveForward(){
        if(Utils.generateRandomNumber() >= Constants.MOVE_NUM){
            position++;
        }
    }

    public String getRoundResult(){
        return name + Constants.ROUND_RESULT_DELIMITER + Utils.createHyphenRepeat(position);
    }

    public int getPosition(){
        return position;
    }

    public boolean isWinner(int winnerScore){
        return position == winnerScore;
    }

    public String getName(){
        return name;
    }
}
