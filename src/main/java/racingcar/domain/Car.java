package racingcar.domain;

public class Car implements Comparable<Car> {

    private static final int MOVE_CONDITION = 4;
    private CarName carName;
    private Distance distance;

    public Car(final String name, final int distance) {
        this.carName = new CarName(name);
        this.distance = new Distance(distance);
    }

    public void move(final int number) {
        if (number >= MOVE_CONDITION) {
            this.distance = distance.increase();
        }
    }

    public String getCarName() {
        return carName.name();
    }

    public int getDistance() {
        return distance.location();
    }


    public boolean isSameDistance(Car competeCar) {
        return this.distance.location() == competeCar.distance.location();
    }

    @Override
    public int compareTo(Car competeCar) {
        return this.distance.location() - competeCar.distance.location();
    }
}