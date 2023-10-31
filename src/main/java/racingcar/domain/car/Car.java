package racingcar.domain.car;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.domain.Movable;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public String getCarDistanceChar() {
        return IntStream.range(0, distance)
                .mapToObj(i -> "-")
                .collect(Collectors.joining());
    }

    public void goForward(Movable movable) {
        if (movable.canMove()) {
            distance++;
        }
    }
}
