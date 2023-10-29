package racingcar.model;

import java.util.List;

public class Car {

    List<String> name;
    List<Integer> move;

    public Car() {

    }

    public Car(List<String> name) {
        this.name = name;
    }

    public List<Integer> getMove() {
        return move;
    }

    public List<String> getName() {
        return name;
    }
}
