package racingcar.game;

import racingcar.io.InputAdaptor;
import racingcar.io.Printer;
import racingcar.util.OutputFormatter;

import java.util.List;
import java.util.Map;

public class Game {
    private static final String UNINITIALIZED_EXCEPTION_MSG = "사용자 입력이 이루어지지 않았습니다.";

    private final InputAdaptor input;

    private GameManager gameManager;
    private String[] cars;
    private int numOfTries;

    public Game(InputAdaptor input) {
        this.input = input;
        this.gameManager = null;
        this.numOfTries = -1;
    }

    public void inputCarNames() {
        Printer.print(OutputFormatter.getMessageWhenInputCarNames());
        String[] carNames = input.readCarNames();
        this.cars = carNames;
        this.gameManager = new GameManager(carNames);
    }

    public void inputNumOfTries() {
        Printer.print(OutputFormatter.getMessageWhenInputNumOfTries());
        this.numOfTries = input.readNumOfTries();
    }

    public void execute() {
        if (this.numOfTries < 0 || this.gameManager == null) {
            throw new IllegalStateException(UNINITIALIZED_EXCEPTION_MSG);
        }

        Printer.print(OutputFormatter.getMessageToIndicateToStartToShowResult());
        for (int i = 0; i < this.numOfTries; i++) {
            executeStep();
            Map<String, Integer> result = this.gameManager.getCurrentCarStates();
            Printer.print(OutputFormatter.getMessageForEachStep(this.cars, result));
        }

        List<String> winners = this.gameManager.getWinners();
        Printer.print(OutputFormatter.getMessageForWinners(winners));
    }

    private void executeStep() {
        for (String car : this.cars) {
            proceedIfSucceeded(car);
        }
    }

    private void proceedIfSucceeded(String car) {
        if (GameManager.isSuccessToProceed()) {
            this.gameManager.proceed(car);
        }
    }
}
