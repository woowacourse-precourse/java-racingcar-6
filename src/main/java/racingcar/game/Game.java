package racingcar.game;

import racingcar.exception.UninitializedException;
import racingcar.io.InputAdaptor;
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
        String[] carNames = input.readCarNames();
        this.cars = carNames;
        this.gameManager = new GameManager(carNames);
    }

    public void inputNumOfTries() {
        this.numOfTries = input.readNumOfTries();
        System.out.println();
    }

    public void execute() {
        if (this.numOfTries < 0 || this.gameManager == null) {
            throw new UninitializedException(UNINITIALIZED_EXCEPTION_MSG);
        }

        System.out.println(OutputFormatter.getMessageToIndicateToStartToShowResult());
        for (int i = 0; i < this.numOfTries; i++) {
            executeStep();
            Map<String, Integer> result = this.gameManager.getCurrentCarStates();
            System.out.println(OutputFormatter.getMessageForEachStep(this.cars, result));
        }

        List<String> winners = this.gameManager.getWinners();
        System.out.println(OutputFormatter.getMessageForWinners(winners));
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
