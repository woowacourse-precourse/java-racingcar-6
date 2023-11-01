package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import console.Validator;
import java.util.List;
import java.util.stream.Collectors;

public class Car {

    private final String name;
    private int distance = 0;

    public Car(String name) {
        Validator.validateCarName(name);
        this.name = name;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) moveForward();
    }

    private void moveForward() {
        this.distance ++;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void printStatus() {
        System.out.println(this.name + " : " + "-".repeat(Math.max(0, this.distance)));
    }

    public int getDistance() {
        return distance;
    }

    public static Car createCar(String name) {
        return new Car(name);
    }

    public static List<Car> decideWinners(List<Car> cars) {
        return cars.stream().filter(car -> car.getDistance() == getMaxDistance(cars)).collect(Collectors.toList());
    }

    private static int getMaxDistance(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getDistance());
        }
        return max;
    }
}
