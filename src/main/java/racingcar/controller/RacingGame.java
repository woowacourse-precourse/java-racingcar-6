package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.NumberGenerator;
import racingcar.view.UserInput;
import racingcar.view.UserOutput;

public class RacingGame {
    private static RacingGame instance; // 게임을 진행할 싱글톤 인스턴스
    private final List<Car> cars;

    private RacingGame() {
        cars = new ArrayList<>();
    }

    private static RacingGame getInstance() {
        if (instance == null) {
            instance = new RacingGame();
        }
        return instance;
    }

    public static void run() {

        UserOutput.askForCarNames();
        String[] carNames = UserInput.readCarName();

        RacingGame game = RacingGame.getInstance();
        game.addCar(carNames);

        UserOutput.askForTryCount();
        int rounds = UserInput.readRound();
        game.play(rounds);

        List<String> result = game.getWinners();
        UserOutput.showWinners(result);

        Console.close();
    }

    private void addCar(String[] input) {

        for (String name : input) {
            cars.add(new Car(name));
        }
    }

    private void play(int rounds) {

        for (int i = 0; i < rounds; i++) {
            playRound();
        }
        UserOutput.printNewLine();
    }

    private void playRound() {
        moveAllCars();
        displayAllCars();
        UserOutput.printNewLine();
    }

    private void moveAllCars() {
        for (Car car : cars) {
            int num = NumberGenerator.createRandomNumber();
            car.move(num);
        }
    }

    private void displayAllCars() {
        for (Car car : cars) {
            UserOutput.displayCar(car);
        }
    }

    private List<String> getWinners() {
        return cars.stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(-1);
    }

}
