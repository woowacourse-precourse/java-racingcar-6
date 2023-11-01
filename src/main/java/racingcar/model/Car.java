package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

import static racingcar.constant.Constant.*;


public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        if (name.length() > MIN_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("Name length should be 5 or less");
        }
        this.name = name;
    }
}