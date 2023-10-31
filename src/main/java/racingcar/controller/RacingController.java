package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Map;

public class RacingController {

    private final RacingService racingService = new RacingService();
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public List<Car> createCarList() {
        String[] carNames = inputView.inputRacingCar();
        return racingService.createCarList(carNames);
    }

}
