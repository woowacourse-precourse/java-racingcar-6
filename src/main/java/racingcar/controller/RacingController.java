package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {


    public void runGame() {
        startGame();
    }


    private void startGame() {
        OutputView.printStartMessage();
        String [] players = InputView.getPlayerInput();
        OutputView.printTryNumberMessage();
        List<String> cars = setPlayerName(players);
        int tryNumber = InputView.getTryNumberInput();
    }

    private List<String> setPlayerName(String [] players) {
        List<String> cars = new ArrayList<>();
        for (String player : players) {
            cars.add(player);
        }
        return cars;
    }
}
