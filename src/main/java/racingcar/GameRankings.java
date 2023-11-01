package racingcar;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class GameRankings {

    private final Map<GameRound, RacingCars> gameRankings = new HashMap<>();

    public void saveEachRoundResult(GameRound gameRound, RacingCars racingCars) {
        gameRankings.put(gameRound, racingCars);
    }

    public RacingCarWinners findWinners() {
        RacingCars racingCars = getFinalResult();
        return racingCars.findWinners();
    }

    private RacingCars getFinalResult() {
        GameRound finalRound = getFinalRound();
        return getFinalRoundResult(finalRound);
    }

    private GameRound getFinalRound() {
        return new GameRound(String.valueOf(gameRankings.size()));
    }

    private RacingCars getFinalRoundResult(GameRound finalRound) {
        return new RacingCars(gameRankings.get(finalRound));
    }

    public Map<GameRound, RacingCars> getGameRankings() {
        return gameRankings;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add("\n실행 결과\n");
        gameRankings.forEach((gameRound, racingCars) -> {
            stringJoiner.add(racingCars.toString());
        });
        return stringJoiner.toString();
    }
}
