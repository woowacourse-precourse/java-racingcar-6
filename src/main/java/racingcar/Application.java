package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class Application {
    private static final String DELIMITER = ",";
    private static final int MOVE_THRESHOLD = 4;

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(DELIMITER);

        System.out.println("시도할 회수는 몇회인가요?");
        int attempts = Integer.parseInt(Console.readLine());

        List<Car> cars = initializeCars(carNames);
        raceCars(cars, attempts);
        printRaceResults(cars);
        printWinners(cars);
    }

    private static List<Car> initializeCars(String[] carNames) {
        return Arrays.stream(carNames)
                .map(Car::new)
                .toList();
    }

    private static void raceCars(List<Car> cars, int attempts) {
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                car.move(Randoms.pickNumberInRange(0, 9));
            }
        }
    }

    private static void printRaceResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getRaceProgress());
        }
    }

    private static void printWinners(List<Car> cars) {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        List<String> winners = cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .toList();

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}

class Car {
    private final String name;
    private int distance = 0;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            distance++;
        }
    }

    public String getRaceProgress() {
        StringBuilder progress = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            progress.append("-");
        }
        return progress.toString();
    }
}