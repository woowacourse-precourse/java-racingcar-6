package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputManager inputManager = new InputManager();

        String[] carNames = inputManager.getCarNames();
        int attempts = inputManager.getAttempts();

        Race race = new Race(Arrays.asList(carNames), attempts);
        race.startRace();
        race.printWinners();
    }
}

class Car {
    private final String name;
    private int position = 0;

    private static final int FORWARD_CONDITION = 4;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if (RandomGenerator.pickNumberInRange(MIN_NUMBER, MAX_NUMBER) >= FORWARD_CONDITION) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public boolean isAtPosition(int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }
}

class CarView {
    public static String displayPosition(Car car) {
        return car.getName() + " : " + "-".repeat(car.getPosition());
    }
}

class Race {
    private final List<Car> carList;
    private final int attempts;

    public Race(List<String> carNames, int attempts) {
        this.carList = createCarsFromNames(carNames);
        this.attempts = attempts;
    }

    private List<Car> createCarsFromNames(List<String> carNames) {
        return carNames.stream().map(Car::new).toList();
    }

    public void startRace() {
        for (int i = 0; i < attempts; i++) {
            raceOnce();
            System.out.println();
        }
    }

    private void raceOnce() {
        carList.forEach(this::moveCarAndDisplayPosition);
    }

    private void moveCarAndDisplayPosition(Car car) {
        car.move();
        printCarPosition(car);
    }

    private void printCarPosition(Car car) {
        System.out.println(CarView.displayPosition(car));
    }

    public void printWinners() {
        List<String> winners = getWinners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private List<String> getWinners() {
        int maxPosition = carList.stream().mapToInt(Car::getPosition).max().orElse(0);

        return carList.stream()
                .filter(car -> car.isAtPosition(maxPosition))
                .map(Car::getName)
                .toList();
    }
}

class RandomGenerator {
    public static int pickNumberInRange(int start, int end) {
        return Randoms.pickNumberInRange(start, end);
    }
}

class InputValidator {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void checkCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다");
            }
        }
    }

    public static void checkAttempts(int attempts) {
        if (attempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1이상이어야 합니다.");
        }
    }
}

class InputManager {

    public String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");

        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].strip();
        }
        InputValidator.checkCarNames(carNames);
        return carNames;
    }

    public int getAttempts() {
        while (true) {
            System.out.println("시도할 횟수는 몇회인가요?");
            try {
                int attempts = Integer.parseInt(Console.readLine());
                InputValidator.checkAttempts(attempts);
                return attempts;
            } catch (IllegalArgumentException e) {
                System.out.println("유효한 숫자를 입력하세요.");
            }
        }
    }
}
