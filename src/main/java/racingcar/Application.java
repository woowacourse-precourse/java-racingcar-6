package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String carNamesInput = inputCarNames();
        validateCarNames(carNamesInput);
        List<String> carNames = List.of(carNamesInput.split(","));

        int attempts = inputAttempts();

        List<Car> cars = createCars(carNames);

        System.out.println();
        System.out.println("실행 결과");
        startRacing(attempts, cars);

        List<String> winners = determineWinners(cars);
        printWinners(winners);

        Console.close();
    }

    private static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static int inputAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private static void validateCarNames(String carNamesInput) {
        String[] carNames = carNamesInput.split(",");
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
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
            moveCars(cars);
            printCurrentPositions(cars);
        }
    }

    private static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move();
        }
    }

    private static void printCurrentPositions(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private static List<String> determineWinners(List<Car> cars) {
        int maxPosition = calculateMaxPosition(cars);
        return findWinners(cars, maxPosition);
    }

    private static int calculateMaxPosition(List<Car> cars) {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }

    private static List<String> findWinners(List<Car> cars, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        printWinnerNames(winners);
    }

    private static void printWinnerNames(List<String> winners) {
        for (int i = 0; i < winners.size(); i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(winners.get(i));
        }
    }
}