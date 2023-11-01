package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.view.GameView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private List<Car> cars;
    private GameView view;

    public GameController() {
        cars = new ArrayList<>();
        view = new GameView();
    }

    public void startGame() {
        view.promptForCarNames();
        String input = Console.readLine();
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
            }
            cars.add(new Car(carName));
        }

        int attempts = view.promptForNumberOfAttempts();
        playGame(attempts);
    }

    private void playGame(int attempts) {
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                car.move();
            }
            view.displayRoundResult(cars);
        }

        List<String> winners = determineWinners();
        view.displayWinners(winners);
    }

    private List<String> determineWinners() {
        int maxPosition = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winners.clear();
                winners.add(car.getName());
            } else if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}