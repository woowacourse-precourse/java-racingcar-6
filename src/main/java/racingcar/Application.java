package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String carNamesInput = Console.readLine("자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분): ");
        List<String> carNames = List.of(carNamesInput.split(","));

        int attempts = Integer.parseInt(Console.readLine("시도할 회수를 입력하세요: "));

        List<Car> cars = createCars(carNames);

        startRacing(attempts, cars);

        List<String> winners = determineWinners(cars);

    }

    private static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void startRacing(int attempts, List<Car> cars) {
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                car.move();
            }
            printCurrentPositions(cars);
        }
    }

    private static void printCurrentPositions(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private static List<String> determineWinners(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}