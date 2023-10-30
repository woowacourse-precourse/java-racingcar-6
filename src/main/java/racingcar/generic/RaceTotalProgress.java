package racingcar.generic;

import java.util.List;
import java.util.stream.Stream;

public record RaceTotalProgress(List<LapProgress> lapProgress) {

    public RaceTotalProgress(List<LapProgress> lapProgress) {
        this.lapProgress = List.copyOf(lapProgress);
    }

    public Stream<LapProgress> stream() {
        return lapProgress.stream();
    }

    public Winners decideWinner() {
        int biggestMileage = getLastLap().getBiggestMileage();
        return new Winners(getLastLap().stream()
                .filter(racer -> racer.mileage() == biggestMileage)
                .map(RacerProgress::name)
                .toList());
    }

    private LapProgress getLastLap() {
        return lapProgress.get(lapProgress.size() - 1);
    }


}
