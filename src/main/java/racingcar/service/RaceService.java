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
    public static void printWinners(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.println("\n" + "최종 우승자 : " + String.join(", ", winners));
    }


}