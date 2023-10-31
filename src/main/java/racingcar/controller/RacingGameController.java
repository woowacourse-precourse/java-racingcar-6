package racingcar.controller;

import static racingcar.util.Converter.stringToCarNameListByDelimiter;
import static racingcar.util.Converter.stringToTryNumber;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.dto.CarDto;
import racingcar.model.Cars;
import racingcar.model.RacingGame;
import racingcar.model.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.vo.CarName;
import racingcar.vo.TryNumber;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = getCars();
        TryNumber tryNumber = getTryNumber();

        RacingGame racingGame = setGame(cars);

        startRacing(cars, tryNumber, racingGame);
        showWinner(racingGame);
    }

    private Cars getCars() {
        outputView.printRequestCarNameMessage();
        List<CarName> carNames = stringToCarNameListByDelimiter(inputView.inputCarNames());
        return new Cars(carNames);
    }

    private TryNumber getTryNumber() {
        outputView.printRequestTryNumberMessage();
        return stringToTryNumber(inputView.inputTryNumber());
    }

    private RacingGame setGame(Cars cars) {
        Referee referee = new Referee();
        return new RacingGame(cars, referee);
    }

    private void startRacing(Cars cars, TryNumber tryNumber, RacingGame racingGame) {
        outputView.printResultMessage();
        IntStream.range(0, tryNumber.number()).forEach(i -> {
            racingGame.proceedOneRound();
            outputView.printResult(CarDto.toDtoList(cars));
        });
    }

    private void showWinner(RacingGame racingGame) {
        List<CarName> winners = racingGame.getWinners();
        outputView.printWinners(winners);
    }
}
