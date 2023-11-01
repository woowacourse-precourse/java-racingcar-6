package racingcar.service;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RaceService {

    public List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public void playGame(List<Car> cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            System.out.println("\n" + "실행 결과");
            for (Car car : cars) {
                car.move();
                System.out.println(car.getName() + " : " + car.getPositionString());
            }
        }
    }



}