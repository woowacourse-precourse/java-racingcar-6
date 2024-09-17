package racingcar.domain;

import racingcar.common.Converter;
import racingcar.common.InputValidator;

import java.util.Map;

public class Car {
    private static final int FORWARD_NUM = 1;
    private static final int FORWARD_LIMIT = 4;


    private boolean isForwardAllowed(int number){
        return number >= FORWARD_LIMIT;
    }

    public int forward(int randomNumber, int distance){
        if(isForwardAllowed(randomNumber)) return distance + FORWARD_NUM;
        return distance;
    }
}
