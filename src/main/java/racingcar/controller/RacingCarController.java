package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.service.ValidateService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Map;

public class RacingCarController {

    private static final int ZERO_VALUE = 0;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingCarService racingCarService = new RacingCarService();
    private final ValidateService validateService = new ValidateService();

    public void playGame() {
        String carNames = carNameInputOutputProcess();
        initGame(carNames);

        String inputNumber = numberInputOutputProcess();
        setCount(inputNumber);

        printExecutionResultMessage();
        gameProcess();
        selectWinner();
    }

    private String carNameInputOutputProcess() {
        outputView.printInputCarNameMessage();
        return inputView.inputCarName();
    }

    private void initGame(String carNames) {
        racingCarService.createCar(carNames);
    }

    private String numberInputOutputProcess() {
        outputView.printInputNumberMessage();
        return inputView.inputNumber();
    }

    private void setCount(String inputNumber) {
        validateService.validateInputNumber(inputNumber);
        racingCarService.setCount(inputNumber);
    }

    private void gameProcess() {
        while (racingCarService.getCount() != ZERO_VALUE) {
            racingCarService.gameProcess();
            List<String> carNames = racingCarService.getCarNames();
            Map<String, Integer> situation = racingCarService.currentSituation();
            for (String carName : carNames) {
                printRoundResult(carName, situation.get(carName));
            }
            printBlankLine();
        }
    }

    private void printExecutionResultMessage() {
        outputView.printExecutionResultMessage();
    }

    private void selectWinner() {
        List<String> winners = racingCarService.getWinners();
        outputView.printWinners(winners);
    }

    private void printRoundResult(String carName, int distance) {
        outputView.printRoundResult(carName, distance);
    }

    private void printBlankLine() {
        outputView.printBlankLine();
    }

}
