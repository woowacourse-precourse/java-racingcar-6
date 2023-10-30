package racingcar;

public class Car {
    private final String car;

    public Car(String car) {
        this.car = car;
    }

    public String getName(){
        return car;
    }

    public String toString() {
        return String.valueOf(this.car);
    }
}
