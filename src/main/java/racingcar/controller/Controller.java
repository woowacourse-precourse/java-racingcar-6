package racingcar.controller;

import static racingcar.util.Constant.ZERO;

import java.util.List;
import java.util.Map;
import racingcar.controller.dto.GameResultResponse;
import racingcar.model.Car;
import racingcar.model.CarName;
import racingcar.model.CarRacingTrackGenerator;
import racingcar.model.RacingGame;
import racingcar.model.RacingTrackGenerator;
import racingcar.model.Vehicle;
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
        List<Car> carNames = getCarNames();
        int attemptsNumber = getAttemptsNumber();
        RacingGame racingGame = createTrack(carNames, attemptsNumber, new CarRacingTrackGenerator());
        outputView.printGameResultMessage();
        while (attemptsNumber-- > ZERO.getValue()) {
            play(racingGame);
        }
        finish(racingGame);
    }

    private void play(final RacingGame racingGame) {
        racingGame.move(new RandomNumberGenerator());
        Map<String, Integer> racingTrack = racingGame.getResult();
        GameResultResponse gameResultResponse = GameResultResponse.from(racingTrack);
        outputView.printGameResult(gameResultResponse);
    }

    private void finish(final RacingGame racingGame) {
        List<String> winners = racingGame.getWinner();
        outputView.printWinner(winners);
    }

    private List<Car> getCarNames() {
        outputView.printCarNameRequestMessage();
        String carNames = inputView.readLine();
        List<String> carNameList = Converter.splitWithComma(carNames);
        return carNameList.stream()
                .map(carName -> Car.createWith(new CarName(carName)))
                .toList();
    }

    private int getAttemptsNumber() {
        outputView.printGameAttemptsNumberRequestMessage();
        String attemptsNumber = inputView.readLine();
        return Converter.stringToInt(attemptsNumber);
    }


    private <T extends Vehicle> RacingGame createTrack(final List<T> carNamesList, final int attemptsNumber,
                                                       final RacingTrackGenerator<T> racingTrackGenerator) {
        return racingTrackGenerator.create(carNamesList, attemptsNumber);
    }
}
