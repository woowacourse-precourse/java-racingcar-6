package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.PlayCount;
import racingcar.model.converter.CarConverter;
import racingcar.model.dto.CarResponse;
import racingcar.model.randomnumber.RandomNumber;
import racingcar.view.input.InputView;
import racingcar.view.output.Outputview;
import java.util.List;

public class GameController {

    private final InputView inputView;
    private final Outputview outputView;
    private final RandomNumber randomNumber;

    public GameController(final InputView inputView, final Outputview outputView, final RandomNumber randomNumber) {
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
        List<CarResponse> carResponses = cars.getCars()
                .stream()
                .map(CarConverter::from)
                .toList();

        carResponses.forEach(response -> {
            outputView.printEachCarStatus(response.getName(), response.getPosition());
        });

        outputView.printBlankLine();
    }

    private void printWinners(final Cars cars) {
        int winnerPosition = cars.calculateWinnersPosition();
        List<String> winners = cars.getCars()
                .stream()
                .filter(car -> car.isPositionEqualTo(winnerPosition))
                .map(CarConverter::from)
                .map(CarResponse::getName)
                .toList();

        outputView.printWinners(winners);
    }
}
