package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Score;
import racingcar.utils.RacingGameMessage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGameView {

    public String getInputLine() {
        return Console.readLine();
    }

    public void raceStartMessage() {
        System.out.println(RacingGameMessage.START_MESSAGE.getStartMessage());
    }

    public void raceCountMessage() {
        System.out.println(RacingGameMessage.REQUEST_RACE_COUNT_MESSAGE.getRequestRaceCountMessage());
    }

    public void raceResults(final List<List<Score>> raceResult) {
        System.out.println();
        System.out.println(RacingGameMessage.GAME_RESULT_MESSAGE.getRaceResultMessage());
        raceResult.forEach(scores -> {
            System.out.print(convertScoreToString(scores));
            System.out.println();
        });
    }

    public String convertScoreToString(final List<Score> oneRoundScore) {
        final String result = oneRoundScore.stream().map(score -> score.getCarName() + " : "
                + convertMoverCountToString(score.getMoveCount()) + "\n")
                .collect(Collectors.joining());

        return result;
    }

    public String convertMoverCountToString(final int moveCount) {
        StringBuilder raceResult = new StringBuilder();
        IntStream.range(0, moveCount).forEach(i -> raceResult.append(RacingGameMessage.MOVE.getMoveMessage()));

        return raceResult.toString();
    }

    public void winners(final List<String> winners) {
        final String result = String.join(", ", winners);

        System.out.println(RacingGameMessage.WINNER_MESSAGE.getWinnerMessage(result));
    }
}
