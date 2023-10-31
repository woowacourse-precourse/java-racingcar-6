package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private Cars cars;
    private int repeatNum;
    private final CarsCreator carsCreator;
    private final RepeatNumCreator repeatNumCreator;

    public RacingGame(CarsCreator carsCreator, RepeatNumCreator repeatNumCreator) {
        this.carsCreator = carsCreator;
        this.repeatNumCreator = repeatNumCreator;
    }
    public void playRacingGame() {
        initRacingGameInput();

        OutputView.printResult();
        while(repeatNum > 0) {
            raceCars();
            repeatNum--;
        }
        printWinners();
    }

    private void printWinners() {
        List<String> winners = cars.findWinner();
        OutputView.printWinners(winners);
    }

    private void raceCars() {
        cars.raceCars();
        cars.getCars().forEach(OutputView::printRace);
        OutputView.printNewLine();
    }

    private void initRacingGameInput() {
        initCars(InputView.inputName());
        initRepeat(InputView.inputRepeat());
    }
    private void initCars(String inputName) {
        this.cars = carsCreator.createCars(inputName);
    }
    private void initRepeat(String inputRepeat) {
        this.repeatNum = repeatNumCreator.createRepeatNum(inputRepeat);
    }
}
