package racingcar;

public class CarGenerator {
    public static Car createCar(String name) {
        return new Car(name);
    }
}