package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Message;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.List;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RaceService raceService;

    public RaceController(InputView inputView, OutputView outputView, RaceService raceService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.raceService = raceService;
    }

    public void run() {
        outputView.printMessage(Message.SET_CAR_NAME);
        List<Car> carList = raceService.getCarList(inputView.input());
        getCount();
        while (!raceService.isEnd()) {
            raceService.race(carList);
        }
    }

    private void getCount() {
        outputView.printMessage(Message.SET_TRY_COUNT);
        raceService.getTryCount(inputView.input());
    }

}
