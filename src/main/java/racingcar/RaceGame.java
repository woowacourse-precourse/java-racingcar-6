package racingcar;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.util.Printer;
import racingcar.util.UserInput;

public class RaceGame {
    Printer printer = new Printer();
    RacePlay racePlay = new RacePlay();
    RaceInfo raceInfo = new RaceInfo();

    public void gameStart() {
        RaceInfo gameInformation = raceInfo.getRaceInfo();
        racePlay.playGame(gameInformation.getGameRound(), gameInformation.getScoreBoard());

        int winPoint = calculateForwardPoint(racePlay.getResultScore());
        printer.printWinnersNames(findWinners(winPoint, racePlay.getResultScore()));
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
