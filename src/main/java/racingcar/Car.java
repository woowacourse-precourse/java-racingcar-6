package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private StringBuilder mileage;
    private static final int MOVABLE_CRITERIA = 4;
    private static final String ONE_MOVE = "-";


    private Car(String name) {
        this.name = name;
        this.mileage = new StringBuilder();

    }

    public static Car createCarByName(String name) {
        return new Car(name);
    }
}
