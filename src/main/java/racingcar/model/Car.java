package racingcar.model;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car implements Comparable<Car> {
    private String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move(int randomValue) {
        if(randomValue >= 4) {
            ++moveCount;
        }
    }

    @Override
    public int compareTo(Car o) {
        return o.getMoveCount() - moveCount;
    }

    @Override
    public String toString() {
        String dashes = IntStream.range(0, moveCount)
                .mapToObj(i -> "-")
                .collect(Collectors.joining());
        return name + " : " + dashes;
    }
}
