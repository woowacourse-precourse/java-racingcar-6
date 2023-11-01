package racingcar.game;

import racingcar.io.InputAdaptor;
import racingcar.io.Printer;
import racingcar.util.OutputFormatter;

import java.util.List;
import java.util.Map;

/**
 * Represents a game in run. Game class is responsible for receiving
 * user inputs, executing a game, and output in appropriate situation.
 * First you should call two methods to invoke the user input needed,
 * and then call execute() method to run a game.
 */
public class Game {
    private static final String UNINITIALIZED_EXCEPTION_MSG = "사용자 입력이 이루어지지 않았습니다.";

    private final InputAdaptor input;

    private GameManager gameManager;
    private String[] cars;
    private int numOfTries;

    /**
     * Constructor.
     * @param input an InputAdaptor object
     */
    public Game(InputAdaptor input) {
        this.input = input;
        this.gameManager = null;
        this.numOfTries = -1;
    }

    /**
     * Let the user enter names of cars.
     * The user input has to be the following form:
     * car1,car2,car3,...
     * Each car name is separated by comma(,).
     * A message saying that the user has to input and how the user input is printed.
     */
    public void inputCarNames() {
        Printer.print(OutputFormatter.getMessageWhenInputCarNames());
        String[] carNames = input.readCarNames();
        this.cars = carNames;
        this.gameManager = new GameManager(carNames);
    }

    /**
     * Let the user enter the number what times steps of the game are executed.
     * A message saying that the user has to input and how the user input is printed.
     */
    public void inputNumOfTries() {
        Printer.print(OutputFormatter.getMessageWhenInputNumOfTries());
        this.numOfTries = input.readNumOfTries();
    }

    /**
     * Executes a game. If the user hasn't entered car names and
     * how many tries would run, an IllegalStateException will be thrown.
     */
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
