package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.RacingService;
import racingcar.service.TrialValidationService;
import racingcar.service.WinnerCheckService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCar {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;
    private final TrialValidationService trialValidationService;
    private final WinnerCheckService winnerCheckService;

    public RacingCar(){
        inputView = new InputView();
        outputView = new OutputView();
        trialValidationService = new TrialValidationService();
        winnerCheckService = new WinnerCheckService();
        racingService = new RacingService();
    }

    public void startRacing(){
        Cars cars = getCars();
        String trial = getTrial();
        for (int i = 0; i < Integer.parseInt(trial); i++) {
            racingService.playRacing(cars);
            outputView.printRacing(cars.getCars());
        }
        List<Car> winners = winnerCheckService.getWinnersList(cars);
        outputView.printWinners(winners);
    }

    private Cars getCars(){
        String carNames = inputView.getCarNames();
        return Cars.from(carNames);
    }

    private String getTrial(){
        String trial = inputView.getTrial();
        trialValidationService.validateTrial(trial);
        return trial;
    }
}
