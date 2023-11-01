package racingcar.controller;

import java.util.List;
import racingcar.controller.dto.GameResultResponse;
import racingcar.model.AttemptCount;
import racingcar.model.Cars;
import racingcar.model.Vehicles;
import racingcar.util.Converter;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    private final OutputView outputView;
    private final InputView inputView;

    public Controller(final OutputView outputView, final InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        Vehicles vehicles = getVehicles();
        AttemptCount attemptCount = getAttemptCount();
        outputView.printGameResultMessage();
        while (!attemptCount.isGameOver()) {
            move(vehicles);
            attemptCount.decrease();
        }
        finish(vehicles);
    }

    private Vehicles getVehicles() {
        outputView.printCarNameRequestMessage();
        String vehicleNames = inputView.readLine();
        List<String> carNameList = Converter.splitWithCommaAndConvertToList(vehicleNames);
        return Cars.createWith(carNameList);
    }

    private AttemptCount getAttemptCount() {
        outputView.printGameAttemptCountRequestMessage();
        String attemptCount = inputView.readLine();
        return new AttemptCount(attemptCount);
    }

    private void move(final Vehicles vehicles) {
        vehicles.moveAll(new RandomNumberGenerator());
        GameResultResponse gameResultResponse = GameResultResponse.from(vehicles.getVehicles());
        outputView.printGameResult(gameResultResponse);
    }

    private void finish(final Vehicles vehicles) {
        List<String> winners = vehicles.getWinner();
        outputView.printWinner(winners);
    }
}
