package racingcar;

import java.util.Collection;

public class GameHost {

    Collection<Car> carList;

    private GameHost(Collection<Car> cars) {
        this.carList = cars;
    }

    public void playOneTurn() {
        carList.forEach((Car::moveForward));
        printAfterOneTurn();
    }

    private void printAfterOneTurn() {
        carList.forEach((car -> System.out.println(car.toString())));
    }

    public static GameHost addCars(Collection<Car> cars) {
        return new GameHost(cars);
    }

}
