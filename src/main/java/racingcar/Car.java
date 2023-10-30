package racingcar;

public class Car implements Comparable<Car> {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void goForward() {
        this.position += 1;
    }

    @Override
    public int compareTo(Car o) {
        return this.position - o.position;
    }

    public String getStatusMessage() {
        return name + " : " + "-".repeat(position);
    }
}
