package racingcar.model;

import java.util.List;
import java.util.stream.IntStream;

public class Car implements Comparable<Car> {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public void forward() {
        this.distance++;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append(this.name).append(" : ");
        IntStream.range(0, this.distance).forEach(i -> sb.append("-"));
        return sb.toString();
    }

    @Override
    public int compareTo(Car o) {
        return this.distance - o.distance;
    }

    public boolean equals(Car o) {
        return o.distance == this.distance;
    }

    public void printName(List<Car> winners) {
        List<String> names = winners.stream().map(winner -> winner.name).toList();
        System.out.println(String.join(", ", names));
    }
}
