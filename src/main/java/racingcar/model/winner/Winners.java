package racingcar.model.winner;

import static java.util.Comparator.comparingInt;

import java.util.List;
import java.util.stream.Stream;

import racingcar.model.car.CarName;
import racingcar.model.race.CarRaceRecord;
import racingcar.model.race.CarRaceRecords;
import racingcar.model.race.RaceResult;

public class Winners {

    private final List<CarName> winners;

    private Winners(final RaceResult result) {
        CarRaceRecords raceRecords = getLastRecordsFrom(result);
        int maxDistance = getMaxDistance(raceRecords);
        this.winners = getWinnerNames(raceRecords, maxDistance);
    }

    public static Winners from(final RaceResult result) {
        return new Winners(result);
    }

    public Stream<CarName> stream() {
        return winners.stream();
    }

    private CarRaceRecords getLastRecordsFrom(final RaceResult result) {
        return result.stream()
                .reduce((first, second) -> second)
                .orElseThrow(IllegalAccessError::new);
    }

    private int getMaxDistance(final CarRaceRecords records) {
        return records.stream()
                .max(comparingInt(CarRaceRecord::distance))
                .orElseThrow(IllegalAccessError::new)
                .distance();
    }

    private List<CarName> getWinnerNames(final CarRaceRecords records, final int maxDistance) {
        return records.stream()
                .filter(record -> record.distance() == maxDistance)
                .map(CarRaceRecord::carName)
                .toList();
    }
}
