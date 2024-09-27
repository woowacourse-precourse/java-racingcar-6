package racingcar.domain.db;

import racingcar.domain.entity.RaceEntity;

public class RaceData {
    private static RaceEntity race;

    public static RaceEntity getRace() {
        return race;
    }

    public static void addRace(RaceEntity newRaceData) {
        race = newRaceData;
    }
}
