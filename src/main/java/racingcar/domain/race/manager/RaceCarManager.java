package racingcar.domain.race.manager;

import racingcar.domain.car.Car;
import racingcar.domain.race.dto.Distance;

import java.util.List;

public class RaceCarManager {
    private final CarRacersRegistry carRacersRegistry;
    private final RaceRecord raceRecord;

    private RaceCarManager(final CarRacersRegistry carRacersRegistry, final RaceRecord raceRecord) {
        this.carRacersRegistry = carRacersRegistry;
        this.raceRecord = raceRecord;
    }

    public static RaceCarManager of(final CarRacersRegistry carRacersRegistry, final RaceRecord raceRecord) {
        return new RaceCarManager(carRacersRegistry, raceRecord);
    }

    public void enlistRacerInRace(final Car car) {
        carRacersRegistry.registerRacer(car);
        raceRecord.addCarToRace(car);
    }

    public List<Car> getRacersList() {
        return carRacersRegistry.getRacersList();
    }

    public void moveForward(final Car car, final String forwardSymbol) {
        raceRecord.moveForward(car, forwardSymbol);
    }

    public Distance getDistanceForCar(final Car car) {
        return raceRecord.getDistanceForCar(car);
    }

    public StringBuilder getFinalWinningCarNames() {
        final StringBuilder result = new StringBuilder();
        final int winDistanceLength = raceRecord.getWinDistanceLength();
        final String COMMA = ",";

        List<Car> winners = raceRecord.findWinners(winDistanceLength);

        for (Car winner : winners) {
            result.append(winner.getName())
                    .append(COMMA);
        }

        result.deleteCharAt(result.length() - 1);
        return result;
    }

}
