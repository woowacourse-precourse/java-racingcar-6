package racingcar.controller;

import static racingcar.util.StringConverter.stringToCarNameListByDelimiter;
import static racingcar.util.StringConverter.stringToInteger;

import java.util.List;
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
        Cars cars = getCarsFromInputView();
        TryNumber tryNumber = getTryNumberFromInputView();

        Referee referee = new Referee();

        RacingGame racingGame = new RacingGame(cars, referee);
        outputView.printResultMessage();

        for (int i = 0; i < tryNumber.number(); i++) {
            racingGame.runOneTerm();
            List<CarDto> carDtoList = CarDto.toDtoList(cars);
            outputView.printResult(carDtoList);
        }

        List<CarName> winners = racingGame.getWinners();
        outputView.printWinners(winners);
    }

    private Cars getCarsFromInputView() {
        outputView.printRequestCarNameMessage();
        List<CarName> carNames = stringToCarNameListByDelimiter(inputView.inputCarNames());
        return new Cars(carNames);
    }

    private TryNumber getTryNumberFromInputView() {
        outputView.printRequestCountMessage();
        Integer number = stringToInteger(inputView.inputTryNumber());
        return new TryNumber(number);
    }
}