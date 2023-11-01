package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private static final String NAME_SEPARATOR = ",";

    public RacingCars generateRacingCarName(final String input) {
        String[] inputName = input.split(NAME_SEPARATOR);
        List<RacingCar> racingCars = new ArrayList<>();

        for (String name : inputName) {
            RacingCar racingCar = new RacingCar(name);
            racingCars.add(racingCar);
        }
        return new RacingCars(racingCars);
    }

    public GameRound generateGameRound(final String input) {
        return new GameRound(input);
    }

    public GameResult race(RacingCars racingCars, final GameRound gameTotalRound, final ForwardMethod forwardMethod) {
        GameRankings gameRankings = new GameRankings();

        for (int round = 1; round <= gameTotalRound.roundNumber(); round++) {
            RacingCars relocatedRacingCars = racingCars.move(forwardMethod);
            racingCars = saveUpdatedRacingCarsPosition(gameRankings, round, relocatedRacingCars);
        }
        return new GameResult(gameRankings);
    }

    private static RacingCars saveUpdatedRacingCarsPosition(GameRankings gameRankings, int round,
                                                            RacingCars relocatedRacingCars) {
        RacingCars updatedRacingCars;

        gameRankings.saveEachRoundResult(new GameRound(String.valueOf(round)), new RacingCars(relocatedRacingCars));
        updatedRacingCars = relocatedRacingCars;
        return updatedRacingCars;
    }
}
