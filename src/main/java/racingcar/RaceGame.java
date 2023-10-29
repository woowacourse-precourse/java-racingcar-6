package racingcar;

import java.util.List;
import java.util.Map;
import racingcar.util.Printer;
import racingcar.util.UserInput;

public class RaceGame {
    private final Printer printer = new Printer();
    private final UserInput userInput = new UserInput();
    private final RaceProcess raceProcess;
    private final RaceResult raceResult;
    private final RacePreparation racePreparation;
    private Map<String, StringBuilder> scoreBoard;
    private int gameRound;

    public RaceGame() {
        this.raceProcess = new RaceProcess();
        this.raceResult = new RaceResult();
        this.racePreparation = new RacePreparation();
    }

    public void setRaceGame() {
        printer.printStartMessage();
        List<String> carNames = userInput.getCarNames();
        scoreBoard = racePreparation.makeScoreBoard(carNames);

        printer.printRequestRoundMessage();
        gameRound = userInput.getGameRound();
    }

    public void start() {
        printer.printResultMessage();
        for (int i = 0; i < gameRound; i++) {
            raceProcess.oneRound(scoreBoard);
            printer.printRoundResult(scoreBoard);
            System.out.println();
        }
    }

    public void gameResult() {
        int maxForwardPoint = raceResult.calculateForwardPoint(scoreBoard);
        List<String> winnerList = raceResult.findWinners(maxForwardPoint, scoreBoard);

        printer.printWinnersNames(winnerList);
    }
}
