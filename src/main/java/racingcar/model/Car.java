package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Car {

    public static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private final List<String> position;

    public Car(String name) {
        this.name = name;
        position = new ArrayList<>();
    }

    public void moveForward() {
        int randomNumber = generateRandomNumber();
        if (randomNumber > 3) {
            position.add("-");
        }
    }

    private static Integer generateRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
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
