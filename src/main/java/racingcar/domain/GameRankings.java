package racingcar.domain;

import java.util.HashMap;
import java.util.Map;
import racingcar.domain.car.RacingCarWinners;
import racingcar.domain.car.RacingCars;

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
}
