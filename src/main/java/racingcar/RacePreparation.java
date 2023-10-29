package racingcar;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.util.Printer;
import racingcar.util.UserInput;

public class RacePreparation {
    private final Printer printer = new Printer();
    private final UserInput userInput = new UserInput();

    private List<String> carNames;
    private int gameRound;
    private Map<String, StringBuilder> scoreBoard;

    public RacePreparation getRaceInformation() {
        this.carNames = inputCarNames();
        this.gameRound = inputGameRound();
        this.scoreBoard = makeScoreBoard();

        return this;
    }

    private List<String> inputCarNames() {
        printer.printStartMessage();

        return userInput.getCarNames();
    }

    private int inputGameRound() {
        printer.printRequestRoundMessage();

        return userInput.getGameRound();
    }

    private Map<String, StringBuilder> makeScoreBoard() {
        Map<String, StringBuilder> scoreBoard = new LinkedHashMap<>();

        for (String name : carNames) {
            scoreBoard.put(name, new StringBuilder());
        }
        return scoreBoard;
    }

    public int getGameRound() {
        return gameRound;
    }

    public Map<String, StringBuilder> getScoreBoard() {
        return scoreBoard;
    }
}
