package racingcar.game;

import racingcar.game.validator.InputValidator;

import static racingcar.controller.constants.IntegerConstants.*;

public class Car {
    private final String name;
    private Integer score;

    public Car(String name){
        InputValidator.lessThenFiveLetters(name);
        this.name = name;
        this.score = STARTING_POINT.getValue();
    }

    public void moveForward(){
        this.score += ONE_STEP.getValue();
    }

    public String getCarName(){
        return this.name;
    }

    public Integer getScore(){
        return this.score;
    }
}
