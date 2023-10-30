package racingcar;

import java.util.List;
import racingcar.game.RaceResult;
import racingcar.game.Round;
import racingcar.game.ScoreBoard;
import racingcar.util.Printer;
import racingcar.util.UserInput;

public class RaceGame {
    private final Printer printer = new Printer();
    private final UserInput userInput = new UserInput();
    private final RaceResult raceResult = new RaceResult();
    private final ScoreBoard scoreBoard;
    private final Round round;

    public RaceGame() {
        printer.printStartMessage();
        this.scoreBoard = new ScoreBoard(userInput.getCarNames());

        printer.printRequestRoundMessage();
        this.round = new Round(userInput.getGameRound());
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
