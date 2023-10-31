package racingcar.controller;

import racingcar.domain.CarContainer;
import racingcar.domain.NumberPicker;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class RacingGameController {
    private static final String NUMBER_ERROR_MESSAGE = " 경기 횟수는 0 미만이면 안됩니다. ";
    private static final String EMPTY_CAR_EXCEPTION = "존재하는 차가 없습니다.";
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
        nameValid(carNames);
        carContainer = new CarContainer(carNames, numberPicker);
    }

    public void nameValid(String carNames) {
        if (carNames == null || carNames.isEmpty() || carNames.length()==1) {
            throw new IllegalArgumentException(EMPTY_CAR_EXCEPTION);
        }
    }

    private void race() {
        int gameCount = validateGameCount();
        outputView.printStatusGuide();
        moveRacingCars(gameCount);
    }

    private void moveRacingCars(int gameCount) {
        for (int currentCount = 0; currentCount < gameCount; currentCount++) {
            carContainer.moveRacingCars();
            outputView.printStatus(carContainer.toDto());
        }
    }
    private int validateGameCount() {
        int gameCount = Integer.parseInt(inputView.inputRaceCount());
        if (gameCount < 0){
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
        return gameCount;
    }

    private void printResult() {
        outputView.printWinner(carContainer.findWinner());
    }

}
