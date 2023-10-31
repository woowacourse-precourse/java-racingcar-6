package racingcar;

public class Car implements Comparable<Car> {
    private String name;
    private int distance;

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            this.distance += 1;
        }
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(distance);
    }

    @Override
    public int compareTo(Car o) {
        return this.distance - o.distance;
    }
}
