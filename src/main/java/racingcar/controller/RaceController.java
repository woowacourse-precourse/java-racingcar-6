package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceController {

    private int playCount;
    private Cars cars;

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

    public void setRace() {
        cars = setCar();
        playCount = setPlayCount();
    }

    private Cars setCar() {
        String inputNames = InputView.askCarName();
        return new Cars(inputNames);
    }

    private int setPlayCount() {
        String inputPlayCount = InputView.askPlayCount();
        return validatePlayCount(inputPlayCount);
    }


    public int validatePlayCount(String inputPlayCount) {

        int playCount;
        try {
            playCount = Integer.parseInt(inputPlayCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (playCount == 0) {
            throw new IllegalArgumentException();
        }

        return playCount;
    }
}
