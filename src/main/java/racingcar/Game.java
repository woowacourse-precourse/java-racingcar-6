package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class Game {
    private final User user = new User();
    private int numberOfTurns;
    private List<Car> cars = new ArrayList<>();;

    public void start() {
        initializeGame();
        playGame();
        displayWinners();
    }

    private void initializeGame() {
        List<String> carNames = user.inputCarNames();
        for (String name : carNames) {
            Car car = new Car(name);
            cars.add(car);
        }
        numberOfTurns = user.inputNumberOfTurns();
    }

    private void playGame() {
        Race race = new Race(cars);
        System.out.println();
        System.out.println("실행 결과");
        for (int turn = 0; turn < numberOfTurns; turn++) {
            race.playRounds();
        }
    }

    private List<String> determineWinners() {
        int maxPoints = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winner = cars.stream()
                .filter(car -> car.getPosition() == maxPoints)
                .map(Car::getName)
                .collect(Collectors.toList());

        return winner;
    }

    private void displayWinners() {
        List<String> winner = determineWinners();
        System.out.print("최종 우승자 : " + String.join(", ", winner));
    }
}
