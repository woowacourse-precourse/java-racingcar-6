package racingcar;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {
    private String name;
    private int location;

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void move(int distance) {
        if (distance >= 4) this.location += distance;
        String result = IntStream.rangeClosed(1, location)
                .mapToObj(i -> "-")
                .collect(Collectors.joining());
        System.out.println(name + " : " + result);
    }
}
