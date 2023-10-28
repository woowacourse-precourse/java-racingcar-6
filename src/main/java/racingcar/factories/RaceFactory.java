package racingcar.factories;

import racingcar.GameRule;
import racingcar.Race;

public class RaceFactory {

    public static Race intializeRace(GameRule rule) {
        return new Race(rule);
    }
}
