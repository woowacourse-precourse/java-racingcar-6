package racingcar.controller;

import java.util.List;
import racingcar.common.StringToListConverter;
import racingcar.common.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private StringToListConverter converter = new StringToListConverter();
    private RacingController racingController = new RacingController();
    private List<String> carNameList;
    private String roundNumber;

    public void raceStart() {
        setCarNames();
        setRoundNumber();
        String winnerName = racingController.proceedRace(carNameList, Integer.parseInt(roundNumber));
        endRace(winnerName);
    }

    public void endRace(String winnerName) {
        outputView.printWinner(winnerName);
    }

    private void setCarNames() {
        outputView.printInputCarNames();
        String carNames = inputView.carNames();
        List<String> carNameList = converter.convert(carNames);
        Validator.validateCarNames(carNameList);
        this.carNameList = carNameList;
    }

    private void setRoundNumber() {
        outputView.printInputRoundNumber();
        String roundNumber = inputView.roundNumber();
        Validator.validateRoundNumber(roundNumber);
        this.roundNumber = roundNumber;
    }
}
