package racingcar.controller;

import static racingcar.util.Constant.ZERO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.controller.dto.GameResultResponse;
import racingcar.model.Car;
import racingcar.model.CarRacingTrackGenerator;
import racingcar.model.Position;
import racingcar.model.RacingGame;
import racingcar.model.RacingTrackGenerator;
import racingcar.model.Vehicle;
import racingcar.util.Converter;
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
        RacingGame racingGame = createTrack(carNames, attemptsNumber);
        outputView.printGameResultMessage();
        while (attemptsNumber-- > ZERO.getValue()) {
            play(racingGame);
        }
        finish(racingGame);
    }

    private void play(final RacingGame racingGame) {
        racingGame.move();
        Map<Vehicle, Position> racingTrack = racingGame.getRacingTrack();
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
                .map(Car::createWith)
                .collect(Collectors.toList());
    }

    private int getAttemptsNumber() {
        outputView.printGameAttemptsNumberRequestMessage();
        String attemptsNumber = inputView.readLine();
        return Converter.stringToInt(attemptsNumber);
    }


    private RacingGame createTrack(final List<Car> carNamesList, final int attemptsNumber) {
        RacingTrackGenerator<Car> racingTrackGenerator = new CarRacingTrackGenerator();
        return racingTrackGenerator.create(carNamesList, attemptsNumber);
    }
}
