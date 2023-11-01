package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        List<Car> cars;
        int numberOfTries;

        cars = initCars();
        numberOfTries = initNumberOfTries();

        start(cars, numberOfTries);
    }
    private static List<Car> initCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        if (carNames == null || carNames.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            if (name.trim().isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException();
            }
            cars.add(new Car(name));
        }
        return cars;
    }
    private static int initNumberOfTries()
    {
        System.out.println("시도할 회수는 몇회인가요?");
        int numberOfTries = Integer.parseInt(Console.readLine());
        if (numberOfTries < 0) {
            throw new IllegalArgumentException("");
        }
        return numberOfTries;
    }
    private static void start(List<Car> cars, int numberOfTries) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < numberOfTries; i++) {
            moveCars(cars);
            printCars(cars);
        }
        announceWinner(cars);
    }
    private static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.moveForward();
            }
        }
    }

    private static void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.printPosition());
        }
        System.out.println();
    }

    private static void announceWinner(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private static int getMaxPosition(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() >= max) {
                max = car.getPosition();
            }
        }
        return max;
    }
}

class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        this.position++;
    }

    public String printPosition() {
        return "-".repeat(this.position);
    }
}
