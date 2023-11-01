package domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

public class RacingGamePlayManager {
    private static final int MOVING_FORWARD_STANDARD_NUMBER = 4;
    private static final String MOVING_FORWARD_SYMBOL = "-";

    public void moveOrStayRacingCars(RacingCar racingCar, int randomValueInRange) {
        if (decideMoveRacingCar(randomValueInRange)) {
            racingCar.moveRacingCar();
        }
    }

    public String getMoveResult(RacingCar racingCar) {
        return racingCar.getName() + " : " + MOVING_FORWARD_SYMBOL.repeat(racingCar.getMoveCount());
    }

    public String getRacingGameResult(Set<RacingCar> racingCarSet) {
        List<String> winnerRacingCarList = findWinnerRacingGame(racingCarSet);
        String result = String.join(", ", winnerRacingCarList);
        return "최종 우승자 : " + result;
    }

    private boolean decideMoveRacingCar(int randomValueInRange) {
        return (randomValueInRange >= MOVING_FORWARD_STANDARD_NUMBER);
    }

    private List<String> findWinnerRacingGame(Set<RacingCar> racingCarSet) {
        int maxMoveCount = racingCarSet.stream()
                .mapToInt(RacingCar::getMoveCount)
                .max()
                .orElseThrow(NoSuchElementException::new);

        return racingCarSet.stream()
                .filter(racingCar -> racingCar.getMoveCount() == maxMoveCount)
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }
}
