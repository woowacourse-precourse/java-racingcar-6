package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.service.CarGameService;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CarGameService carGameService;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carGameService = new CarGameService();
    }

    public void start() {
        outputView.printInitGame();
        List<String> carNames = carGameService.extractSeperator(inputView.inputCarName());
        outputView.printBeforeInputGameCount();
        Integer gameCount = carGameService.convertGameCountToNumber(inputView.inputGameCount());
        List<Car> cars = new ArrayList<>();
        carGameService.initCarInfo(carNames, cars);
        outputView.notifyBeforeResult();
        for(int count=0; count<gameCount; count++){
            printRoundResult(carGameService.roundResult(cars));
        }



    }

    private void printRoundResult(List<String> result) {
        outputView.printRoundResult(result);
    }

}
