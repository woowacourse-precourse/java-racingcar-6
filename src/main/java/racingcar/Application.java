package racingcar;

import java.util.*;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application racingCar = new Application();
        List<Car> cars = racingCar.createCars();
        int attempts = racingCar.getAttempts();

        racingCar.startRace(cars, attempts);
    }

    private List<Car> createCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");
        validateCarNames(carNames);
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }

    private int getAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }
    }

    private void startRace(List<Car> cars, int attempts) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < attempts; i++) {
            moveCars(cars);
            printCurrentPosition(cars);
        }
        announceWinners(cars);
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            int number = Randoms.pickNumberInRange(0, 9);
            if (number >= 4) {
                car.move();
            }
        }
    }

    private void printCurrentPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPositionView());
        }
        System.out.println();
    }

    private void announceWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }
}

class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        this.position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionView() {
        return "-".repeat(position);
    }
}

class racingCar {
    private String name;
    private int movement;

    public racingCar(String name) {
        this.name = name;
        this.movement = 0;
    }

    public void move() {
        Random random = new Random();
        int distance = random.nextInt(10);
        if (distance >= 4) {
            this.movement += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getMovement() {
        return movement;
    }
}
