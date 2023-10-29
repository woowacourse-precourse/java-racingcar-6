package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceController {

    private int playCount;
    private Cars cars;

    public RaceController() {
        setRace();
    }

    public void play() {

        for(int i = 0; i < playCount; i++) {
            if(i == 0) {
                OutputView.printResultMessage();
            }
            cars.play();
            OutputView.printResult(cars.toDto());
        }

        List<String> winners = cars.findWinners();
        OutputView.printFinalWinner(winners);
    }

    private void setRace() {
        cars = setCar();
        playCount = setPlayCount();
    }

    private Cars setCar() {
        String inputNames = InputView.askCarName();
        return new Cars(inputNames);
    }

    private int setPlayCount() {
        try {
            int playCount = Integer.parseInt(InputView.askPlayCount());
            if (playCount == 0) {
                throw new IllegalArgumentException();
            }
            return playCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
