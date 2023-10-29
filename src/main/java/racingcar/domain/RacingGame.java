package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static RacingGame instance;
    private final List<Car> cars;

    private RacingGame() {
        cars = new ArrayList<>();
    }

    public static RacingGame getInstance() {
        if (instance == null) {
            instance = new RacingGame();
        }
        return instance;
    }

    public void addCar(String input) {

        String[] carNames = input.split(",");

        for (String name : carNames) {
            if (Validator.isValidCarName(name)) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            Car car = new Car(name);
            cars.add(car);
        }
    }

    public void play(String input) {

        int rounds = Integer.parseInt(input);

        for (int round = 0; round < rounds; round++) {
            playRound();
        }
    }

    private void playRound() {
        moveAllCars();
        displayAllCars();
        printNewLine();
    }

    private void moveAllCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void displayAllCars() {
        for (Car car : cars) {
            car.display();
        }
    }

    private void printNewLine() {
        System.out.println();
    }

    public String getWinners() {
        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .map(Car::getName)
                .collect(Collectors.toList());

        return String.join(", ", winners);
    }

    private int getMaxPosition(){
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(-1);
    }

}
