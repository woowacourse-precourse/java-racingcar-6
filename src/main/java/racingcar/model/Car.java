package racingcar.model;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {
    private String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public void move(int randomValue) {}

    @Override
    public String toString() {
        String dashes = IntStream.range(0, moveCount)
                .mapToObj(i -> "-")
                .collect(Collectors.joining());
        return name + " : " + dashes;
    }
}
