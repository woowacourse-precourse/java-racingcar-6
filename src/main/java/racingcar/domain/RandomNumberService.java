package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberService {
    RandomNumber randomNumber;
    List<Boolean> isMoving;
    int moveNumber;


    public RandomNumberService(int moveNumber){
        randomNumber = new RandomNumber();
        this.moveNumber = moveNumber;
        isMoving = new ArrayList<>();
    }

    public List<Boolean> makeResult(){
        for(int i=0; i<moveNumber; i++){
            int newNumber = randomNumber.getNumber();
            isMoving.add(move(newNumber));
        }

        return isMoving;
    }
    public boolean move(int number){
        return number >= 4;
    }
}
