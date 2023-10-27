package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

/*
 *   플레이어의 정보를 담당
 * */

public class GamePlayer {
    private final List<Car> cars = new ArrayList<>();

    public GamePlayer() {
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void printPlayerCars() {
        System.out.println(this.cars);
    }
}
