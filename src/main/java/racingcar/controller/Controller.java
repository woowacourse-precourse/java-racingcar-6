package racingcar.controller;

import static racingcar.util.Constant.ZERO;

import java.util.List;
import racingcar.controller.dto.GameResultResponse;
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
        int attemptsNumber = getAttemptsNumber();
        outputView.printGameResultMessage();
        while (attemptsNumber-- > ZERO.getValue()) {
            move(vehicles);
        }
        finish(vehicles);
    }

    private Vehicles getVehicles() {
        outputView.printCarNameRequestMessage();
        String vehicleNames = inputView.readLine();
        List<String> carNameList = Converter.splitWithCommaAndConvertToList(vehicleNames);
        return Cars.createWith(carNameList);
    }

    private int getAttemptsNumber() {
        outputView.printGameAttemptsNumberRequestMessage();
        String attemptsNumber = inputView.readLine();
        return Converter.stringToInt(attemptsNumber);
    }

    private void move(final Vehicles vehicles) {
        vehicles.moveAll(new RandomNumberGenerator());
        GameResultResponse gameResultResponse = GameResultResponse.from(vehicles.getResult());
        outputView.printGameResult(gameResultResponse);
    }

    private void finish(final Vehicles vehicles) {
        List<String> winners = vehicles.getWinner();
        outputView.printWinner(winners);
    }
}
