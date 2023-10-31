package racingcar.domain.race;

import racingcar.domain.car.Car;
import racingcar.domain.factory.CarFactory;
import racingcar.domain.race.dto.Distance;
import racingcar.domain.race.manager.RaceCarManager;
import racingcar.domain.race.rule.Rule;

public class Race {
    private final RaceCarManager raceCarManager;
    private final Rule rule;

    private Race(final RaceCarManager raceCarManager, final Rule rule) {
        this.raceCarManager = raceCarManager;
        this.rule = rule;
    }

    public static Race of(final RaceCarManager raceCarManager, final Rule rule) {
        return new Race(raceCarManager, rule);
    }

    public void addCarToRace(final String[] names) {
        for (String name : names) {
            raceCarManager.enlistRacerInRace(CarFactory.newIntanceCar(name));
        }
    }

    public void startOneLap() {
        final String FORWARD_SYMBOL = "-";

        raceCarManager.getRacersList().stream()
                .filter(car -> rule.isForward(car.getAccelerationValue()))
                .forEach(car -> raceCarManager.moveForward(car, FORWARD_SYMBOL));
    }

    public String getLapResult() {
        final StringBuilder recordResult = makeRecordResult();
        return recordResult.toString();
    }

    public String getFinalWinningCarNames() {
        final StringBuilder result = raceCarManager.getFinalWinningCarNames();
        return result.toString();
    }

    private StringBuilder makeRecordResult() {
        final StringBuilder recordResult = new StringBuilder();

        for (Car car : raceCarManager.getRacersList()) {
            Distance distance = raceCarManager.getDistanceForCar(car);
            makeMessage(recordResult, car, distance);
        }

        return recordResult;
    }

    private static void makeMessage(final StringBuilder recordResult, final Car car, final Distance distance) {
        final String COLON_SEPARATOR = " : ";
        recordResult.append(car.getName())
                .append(COLON_SEPARATOR)
                .append(distance.toString())
                .append(System.lineSeparator());
    }

}
