package racingcar.model;

import racingcar.validator.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class Car {

    public static final int MAX_NAME_LENGTH = 5;
    private static final String POSITION_MARKER = "-";
    private static final int MOVE_CONDITION_VALUE = 4;
    private final String name;
    private final List<String> position;

    public Car(String name) {
        InputValidator.validateNameLength(name);
        InputValidator.validateName(name);
        this.name = name;
        position = new ArrayList<>();
    }

    public void moveForward(Integer randomNumber) {
        if (randomNumber >= MOVE_CONDITION_VALUE) {
            position.add(POSITION_MARKER);
        }
    }
    public String getRoundResult(){
        return name + " : " + getConcatenatedPosition();
    }

    private String getConcatenatedPosition(){
        return String.join("", position);
    }

    public Integer getPosition(){
        return position.size();
    }

    public String getName(){
        return name;
    }
}
