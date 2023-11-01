package racingcar;

import java.util.StringJoiner;

public class GameResult {

    private final GameRankings gameRanking;
    private final RacingCarWinners winners;

    public GameResult(final GameRankings gameRanking) {
        this.gameRanking = gameRanking;
        winners = gameRanking.findWinners();
    }

    public GameRankings getEachRoundResult() {
        return gameRanking;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        StringJoiner stringJoiner = new StringJoiner(", ");

        stringBuilder.append("최종 우승자 : ");
        for (Name winnerNames : winners.winners()) {
            stringJoiner.add(winnerNames.name());
        }
        stringBuilder.append(stringJoiner);
        return stringBuilder.toString();
    }
}
