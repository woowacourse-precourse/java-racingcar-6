package racingcar.domain.race.manager;

import racingcar.domain.car.Car;
import racingcar.domain.race.dto.Distance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RaceRecord {

    private final Map<Car, Distance> record = new HashMap<>();

    private RaceRecord() {
    }

    public static RaceRecord newInstance() {
        return new RaceRecord();
    }

    public void addCarToRace(final Car car) {
        record.put(car, new Distance(new StringBuilder()));
    }

    public void moveForward(final Car car, final String forWardSymbol) {
        final Distance distance = record.get(car);
        distance.move(forWardSymbol);
        record.put(car, distance);
    }

    public List<Car> findWinners(final int winDistanceLength) {
        return new ArrayList<>(record.entrySet().stream()
                .filter(car -> car.getValue().getLength() == winDistanceLength)
                .map(Map.Entry::getKey)
                .toList());
    }

    public Distance getDistanceForCar(final Car car) {
        return record.get(car);
    }

    public int getWinDistanceLength() {
        int length = Integer.MIN_VALUE;

        for (Distance value : record.values()) {
            length = Math.max(length, value.getLength());
        }

        return length;
    }

}
