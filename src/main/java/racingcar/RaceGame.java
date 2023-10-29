package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import racingcar.util.Printer;

public class RaceGame {
    private final Printer printer = new Printer();
    private final RaceProcess raceProcess = new RaceProcess();
    private final RacePreparation racePreparation = new RacePreparation();
    private final RaceResult raceResult = new RaceResult();

    public void gameStart() {
        RacePreparation gameInformation = racePreparation.getRaceInformation();
        raceProcess.playGame(gameInformation.getGameRound(), gameInformation.getScoreBoard());

        int winPoint = raceResult.calculateForwardPoint(raceProcess.getResultScore());
        List<String> winnerList = raceResult.findWinners(winPoint, raceProcess.getResultScore());
        printer.printWinnersNames(winnerList);
    }
}
