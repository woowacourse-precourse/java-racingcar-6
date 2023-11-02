package racingcar;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        List<String> names = askName();
        List<Car> cars = initializeCars(names);

        int rounds = askCount();
        displayGameHeader();

        playGame(cars, rounds);
        printResult(cars);
    }

    private static List<Car> initializeCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void playGame(List<Car> cars, int rounds) {
        for (int i = 0; i < rounds; i++) {
            playRound(cars);
            displayRoundResults(cars);
        }
    }

    private static void playRound(List<Car> cars) {
        for (Car car : cars) {
            car.tryToMove();
        }
    }

    private static void displayRoundResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            displayCarPosition(car);
            System.out.println();
        }
        System.out.println();
    }

    private static void displayCarPosition(Car car) {
        for (int j = 0; j < car.getMoveCount(); j++) {
            System.out.print("-");
        }
    }

    public static List<String> askName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = readLine().split(",");
        validateNames(names);
        return new ArrayList<>(Arrays.asList(names));
    }

    private static void validateNames(String[] names) {
        for (String name : names) {
            validateName(name);
        }
    }

    public static void validateName(String name) {
        if (name.trim().isEmpty() || name.contains(" ") || name.length() > 5) {
            throw new IllegalArgumentException("잘못된 이름이 포함되어 있습니다. 이름을 다시 입력하세요.");
        }
    }

    public static int askCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(readLine());
    }

    private static void displayGameHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printResult(List<Car> cars) {
        System.out.println("최종 우승자 : " + String.join(", ", findWinners(cars)));
    }

    private static List<String> findWinners(List<Car> cars) {
        int maxValue = findMaxMoveCount(cars);
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getMoveCount() == maxValue) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    public static int findMaxMoveCount(List<Car> cars) {
        int maxValue = Integer.MIN_VALUE;
        for (Car car : cars) {
            maxValue = Math.max(maxValue, car.getMoveCount());
        }
        return maxValue;
    }
}
