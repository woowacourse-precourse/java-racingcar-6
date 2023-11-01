package racingcar.config;

import racingcar.domain.race.Race;
import racingcar.domain.race.manager.CarRacersRegistry;
import racingcar.domain.race.manager.RaceCarManager;
import racingcar.domain.race.manager.RaceRecord;
import racingcar.domain.race.rule.Rule;

public class RaceFactory {
    private static Race race;

    private static RaceCarManager raceCarManager;
    private static Rule rule;

    private static CarRacersRegistry carRacersRegistry;
    private static RaceRecord raceRecord;

    private RaceFactory() {
    }

    protected static Race createSingletonRace() {
        if (race == null) {
            race = Race.of(createSingletonRaceCarManager(), createSingletonRule());
        }

        return race;
    }

    private static RaceCarManager createSingletonRaceCarManager() {
        if (raceCarManager == null) {
            raceCarManager = RaceCarManager.of(createSingletonCarRacersRegistry(), createSingletonRaceRecord());
        }

        return raceCarManager;
    }

    private static Rule createSingletonRule() {
        if (rule == null) {
            rule = Rule.newInstance();
        }

        return rule;
    }

    private static CarRacersRegistry createSingletonCarRacersRegistry() {
        if (carRacersRegistry == null) {
            carRacersRegistry = CarRacersRegistry.newInstance();
        }

        return carRacersRegistry;
    }

    private static RaceRecord createSingletonRaceRecord() {
        if (raceRecord == null) {
            raceRecord = RaceRecord.newInstance();
        }

        return raceRecord;
    }

}
