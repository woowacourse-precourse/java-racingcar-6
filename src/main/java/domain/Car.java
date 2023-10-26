package domain;

public class Car implements Comparable<Car> {

    private final String name;
    private int distance;

    Car(final String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    Car(final String name) {
        this.name = name;
    }


    void move(final int value) {
        if(value > 3) {
            distance++;
        }
    }

    int getDistance() { return distance; }
    String getName() { return name; }

    @Override
    public int compareTo(Car o) {
        return o.distance - this.distance;
    }
}
