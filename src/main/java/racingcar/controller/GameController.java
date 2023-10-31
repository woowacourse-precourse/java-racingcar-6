package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.PlayCount;
import racingcar.model.dto.CarResponse;
import racingcar.model.randomnumber.RandomNumber;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;
import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomNumber randomNumber;

    public GameController(final InputView inputView, final OutputView outputView, final RandomNumber randomNumber) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomNumber = randomNumber;
    }

    public void play() {
        outputView.askCarNames();
        Cars playCars = Cars.from(inputView.readLine());

        outputView.askPlayCount();
        PlayCount playCount = PlayCount.createDefault(inputView.readLine());

        outputView.printResult();
        while (!playCount.isGameEnd()) {
            playCars.race(randomNumber);
            printEachStatus(playCars);
            playCount.endOneRound();
        }

        printWinners(playCars);
    }

    private void printEachStatus(final Cars cars) {
        List<CarResponse> carResponses = getCarResponses(cars);

        outputView.printEachCarStatus(carResponses);
        outputView.printBlankLine();
    }

    private void printWinners(final Cars cars) {
        List<CarResponse> winners = getWinnerResponses(cars);
        outputView.printWinners(winners);
    }

    private static List<CarResponse> getWinnerResponses(final Cars cars) {
        int maxPosition = cars.calculateWinnersPosition();

        return getCarResponses(cars)
                .stream()
                .filter(response -> response.position() == maxPosition)
                .toList();
    }

    private static List<CarResponse> getCarResponses(final Cars cars) {
        return cars.getCars()
                .stream()
                .map(car -> CarResponse.of(car.getName(), car.getPosition()))
                .toList();
    }
}
