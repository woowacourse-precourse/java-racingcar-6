package racingcar;

import java.util.List;

public record RacingCarWinners(List<RacingCar> winners) {

    public RacingCar get(int index) {
        return winners.get(index);
    }
}
