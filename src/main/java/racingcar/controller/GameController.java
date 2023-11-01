package racingcar.controller;

import java.util.List;
import racingcar.common.StringToListConverter;
import racingcar.common.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private StringToListConverter stringToListConverter = new StringToListConverter();
    private RacingController racingController = new RacingController();

    public void raceStart() {
        List<String> carNameList = setCarNames();
        String roundNumber = setRoundNumber();
        String winnerName = racingController.proceedRace(carNameList, Integer.parseInt(roundNumber));
        endRace(winnerName);
    }

    public void endRace(String winnerName) {
        outputView.printWinner(winnerName);
    }

    private List<String> setCarNames() {
        outputView.printInputCarNames();
        String carNames = inputView.carNames();
        List<String> carNameList = stringToListConverter.convert(carNames);
        Validator.validateCarNames(carNameList);
        return carNameList;
    }

    private String setRoundNumber() {
        outputView.printInputRoundNumber();
        String roundNumber = inputView.roundNumber();
        Validator.validateRoundNumber(roundNumber);
        return roundNumber;
    }
}
