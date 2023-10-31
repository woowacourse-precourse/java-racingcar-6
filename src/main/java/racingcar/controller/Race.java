package racingcar.controller;

import java.util.stream.IntStream;
import racingcar.model.Cars;
import racingcar.view.OutputView;

public class Race {
    private Cars cars;
    private int tryCount;
    public Race(){
        set();
        play();
        showWinners();
    }
    public void set(){
        cars = Input.setRacingCars();
        tryCount = Input.setTryCount();
    }
    public void play(){
        OutputView.printStartMessage();
        IntStream.range(0, tryCount)
                .forEach(i -> cars.racePerTryCount());
    }
    public void showWinners(){
        cars.showWinners();
    }
}