package racingcar;

import java.util.List;
import racingcar.game.RaceResult;
import racingcar.game.Round;
import racingcar.game.ScoreBoard;
import racingcar.util.Printer;
import racingcar.util.UserInput;

public class RaceGame {
    private final Printer printer = new Printer();
    private final RaceResult raceResult = new RaceResult();
    private final ScoreBoard scoreBoard;
    private final Round round;

    public RaceGame() {
        UserInput userInput = new UserInput();
        printer.printStartMessage();
        this.scoreBoard = new ScoreBoard(userInput.getUserInput());

        printer.printRequestRoundMessage();
        this.round = new Round(userInput.getUserInput());
    }

    public void start() {
        printer.printResultMessage();
        for (int i = 0; i < round.getRound(); i++) {
            scoreBoard.updateScore();
            printer.printRoundResult(scoreBoard);
        }
    }

    public void gameResult() {
        int maxForwardPoint = raceResult.calculateForwardPoint(scoreBoard);
        List<String> winnerList = raceResult.findWinners(maxForwardPoint, scoreBoard);

        printer.printWinnersNames(winnerList);
    }

}
