package racingcar.model;

import java.util.stream.IntStream;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public static Car of(String name){
        return new Car(name);
    }

    public void addDistance() {
        this.distance++;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append(this.name).append(" : ");
        IntStream.range(0,this.distance).forEach(i -> sb.append("-"));
        return sb.toString();
    }
}
