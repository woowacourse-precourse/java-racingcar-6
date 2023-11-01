package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {
    private RacingCar racingCar;
    private Integer count;


    public void start() {
        OutputView.printCarNameInputMessage();
        createRacingCar(InputView.inputCarName());

        OutputView.printRacingCountInputMessage();
        initializeCount(InputView.inputRacingCount());


        OutputView.printRacingResultStartMessage();
        for (int i = 0; i < count; i++) {
            racingCar.stopOrMoveForward();
            OutputView.printAllCarNowDistance(racingCar.distanceString());
        }

        OutputView.printWinnerMessage(racingCar.determineWinner());
    }

    private void createRacingCar(List<String> playerCarNameList) {
        racingCar = new RacingCar(playerCarNameList);
    }

    private void initializeCount(Integer count) {
        this.count = count;
    }
}