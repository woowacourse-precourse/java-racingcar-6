package racingcar.domain.car;

public class Car implements Comparable<Car> {


    private CarName carName;
    private int position;

    private Car(CarName carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public void move() {
        this.position++;
    }

    public boolean isSamePosition(Car other) {
        return this.position == other.position;
    }

    @Override
    public int compareTo(Car o) {
        return this.position - o.position;
    }


    public int getPosition() {
        return position;
    }

    public String getName() {
        return carName.getName();
    }

    public static Car createCar(CarName carName, int position) {
        return new Car(carName, position);
    }
}
