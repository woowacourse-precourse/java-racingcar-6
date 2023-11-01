package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Score;
import racingcar.utils.RacingGameMessage;

import java.util.List;
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
        for(int i = 0; i < raceResult.size(); i++) {
            System.out.print(convertScoreToString(raceResult.get(i)));
            System.out.println();
        }
    }

    public String convertScoreToString(List<Score> oneRoundScore) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < oneRoundScore.size(); i++) {
            stringBuilder.append(oneRoundScore.get(i).getCarName());
            stringBuilder.append(" : ");
            stringBuilder.append(convertMoverCountToString(oneRoundScore.get(i).getMoveCount()));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
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
