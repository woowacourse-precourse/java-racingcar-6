package racingcar.domain;

import racingcar.vaildator.InputValidator;

import static racingcar.Constant.EXCEPTION_MESSAGE;
import static racingcar.vaildator.InputValidator.*;

public class Car {

    private String carName;
    private int numberOfStep;

    public Car(String carName){
        String trimCarName = removeTrimString(carName);

        isBlankInput(trimCarName);
        isValidLengthCarNames(trimCarName);

        this.carName = trimCarName;
    }

    public void forward(int number){
        if(number < 4) return;

        addStep();
    }

    public String getCarName(){
        return carName;
    }

    public int getNowStep(){
        return numberOfStep;
    }

    private void addStep(){
        this.numberOfStep += 1;
    }

}
