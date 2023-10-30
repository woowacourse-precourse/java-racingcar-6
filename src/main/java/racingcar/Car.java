package racingcar;

public class Car implements Comparable<Car>{

    public String name;
    public Integer distance;
    @Override
    public int compareTo(Car o) {
        return o.distance - distance;
    }

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }
}
