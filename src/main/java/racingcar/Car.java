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
        return o.position - this.position;
    }

    public boolean equalsPosition(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position;
    }

    public String getStatusMessage() {
        return name + " : " + "-".repeat(position);
    }

    public String getName() {
        return name;
    }
}
