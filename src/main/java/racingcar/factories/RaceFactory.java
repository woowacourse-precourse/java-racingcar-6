package racingcar.factories;

import racingcar.underhood.GameRule;
import racingcar.underhood.Race;

public class RaceFactory {

    public static Race intializeRace(GameRule rule) {
        return new Race(rule);
    }
}
