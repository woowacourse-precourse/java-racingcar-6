package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import racingcar.util.Printer;

public class RaceGame {
    private final Printer printer = new Printer();
    private final RaceProcess raceProcess = new RaceProcess();
    private final RacePreparation racePreparation = new RacePreparation();

    public void gameStart() {
        RacePreparation gameInformation = racePreparation.getRaceInformation();
        raceProcess.playGame(gameInformation.getGameRound(), gameInformation.getScoreBoard());

        int winPoint = calculateForwardPoint(raceProcess.getResultScore());
        printer.printWinnersNames(findWinners(winPoint, raceProcess.getResultScore()));
    }

    public int calculateForwardPoint(Map<String, StringBuilder> scoreResult) {

        return scoreResult.values().stream().mapToInt(StringBuilder::length).max().orElse(0);
    }

    public List<String> findWinners(int maxForwardPoint, Map<String, StringBuilder> scoreBoard) {
        List<String> winnerList = new ArrayList<>();

        scoreBoard.forEach((key, value) -> {
            if (value.length() == maxForwardPoint) {
                winnerList.add(key);
            }
        });
        return winnerList;
    }
}
