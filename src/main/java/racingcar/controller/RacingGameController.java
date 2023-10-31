package racingcar.controller;

import racingcar.domain.CarContainer;
import racingcar.domain.NumberPicker;
import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private static final String NUMBER_ERROR_MESSAGE = " 경기 횟수는 0 미만이면 안됩니다. ";
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberPicker numberPicker;
    private CarContainer carContainer;

    public RacingGameController(NumberPicker numberPicker, OutputView outputView, InputView inputView) {
        this.numberPicker = numberPicker;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void gameProcess(){
        raceStart();
        race();
        printResult();
    }

    private void raceStart() {
        String carNames = inputView.inputCarName();
        carContainer = new CarContainer(carNames, numberPicker);
    }

    private void race() {
        int gameCount = Integer.parseInt(inputView.inputRaceCount());
        if (gameCount < 0){
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
        outputView.printStatusGuide();
        for (int currentCount = 0; currentCount < gameCount; currentCount++) {
            carContainer.moveRacingCars();
            outputView.printStatus(carContainer.toDto());
        }
    }

    private void printResult() {
        outputView.printWinner(carContainer.findWinner());
    }

}
