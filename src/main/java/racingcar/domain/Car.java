package racingcar.domain;

/*
 *   자동차의 관한 정보를 담당
 * */

import java.util.List;

public class Car {

    private static final int MOVE_COUNT_INITIAL = 0;
    private String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
        moveCount = MOVE_COUNT_INITIAL;
    }

    public void addNameToList(List<String> names) {
        names.add(name);
    }


    public void move() {
        moveCount++;
    }


    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
