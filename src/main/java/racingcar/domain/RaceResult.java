package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RaceResult {
    private final List<RoundResult> roundResults;

    public RaceResult() {
        this.roundResults = new ArrayList<>();
    }

    public RaceResult(List<Car> cars) {
        this.roundResults = new ArrayList<>();
        addRoundResult(cars);
    }

    public void addRoundResult(List<Car> cars) {
        List<CarSnapshot> carSnapshots = cars.stream()
                .map(CarSnapshot::new)
                .collect(Collectors.toList());

        roundResults.add(new RoundResult(carSnapshots));
    }

    public List<RoundResult> getRoundResults() {
        return Collections.unmodifiableList(roundResults);
    }

    public List<String> getWinners() {
        int lastRoundIndex = roundResults.size() - 1;
        RoundResult lastRoundResult = roundResults.get(lastRoundIndex);

        int maxPosition = lastRoundResult.getMaxPosition();

        return lastRoundResult.getCarNamesAtPosition(maxPosition);
    }

    public Map<String, Integer> getRoundProgress() {
        int lastRoundIndex = roundResults.size() - 1;
        RoundResult lastRoundResult = roundResults.get(lastRoundIndex);
        return lastRoundResult.getCarNamesWithPositions();
    }

    static class RoundResult extends RaceResult {
        private final List<CarSnapshot> carSnapshots;

        RoundResult(List<CarSnapshot> carSnapshots) {
            this.carSnapshots = carSnapshots;
        }

        int getMaxPosition() {
            return carSnapshots.stream()
                    .mapToInt(CarSnapshot::getPosition)
                    .max()
                    .orElse(0);
        }

        List<String> getCarNamesAtPosition(int position) {
            return carSnapshots.stream()
                    .filter(snapshot -> snapshot.getPosition() == position)
                    .map(CarSnapshot::getName)
                    .collect(Collectors.toList());
        }

        public CarSnapshot getSnapshotForCarName(String carName) {
            return carSnapshots.stream()
                    .filter(snapshot -> snapshot.getName().equals(carName))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("해당 이름의 자동차가 없습니다."));
        }

        Map<String, Integer> getCarNamesWithPositions() {
            return carSnapshots.stream()
                    .collect(Collectors.toMap(CarSnapshot::getName, CarSnapshot::getPosition));
        }

    }

    static class CarSnapshot {
        private final String name;
        private final int position;

        CarSnapshot(Car car) {
            this.name = car.getName();
            this.position = car.getPosition();
        }

        String getName() {
            return name;
        }

        int getPosition() {
            return position;
        }
    }
}
