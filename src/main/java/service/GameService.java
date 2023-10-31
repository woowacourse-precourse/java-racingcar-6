package service;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Car;

import java.util.List;
import java.util.stream.Collectors;

import static view.View.*;

public class GameService {
    CarService carService = new CarService();
    public void play() {
        List<String> carNames = carService.getCarNames(getInputLineOfCarNames());
        List<Car> cars = carService.createCars(carNames);
        int numberOfAttempts = getNumberOfAttempts();
        printHeadResult();
        attempt(cars,numberOfAttempts);
        printWinner(cars);
    }
    private static void attemptOneRound(List<Car> cars) {
        cars.forEach(car -> {
            if (isMove()) {
                car.moveForward();
            }
        });
    }

    private static boolean isMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    private static void attempt(List<Car> cars, int numberOfAttempts){
        for (int i = 0; i < numberOfAttempts; i++) {
            attemptOneRound(cars);
            printOneRoundResult(cars);
        }
    }
    private static void printOneRoundResult(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.toString()));
        System.out.println();
    }

    private static List<String> findWinner(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        List<String> winner = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
        return winner;
    }

    private static int findMaxPosition(List<Car> cars) {
        int maxPosition = -1;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private static void printWinner(List<Car> cars) {
        List<String> winner = findWinner(cars);
        String result = String.join(",", winner);
        System.out.println(String.format("최종 우승자 : %s", result));
    }
}
