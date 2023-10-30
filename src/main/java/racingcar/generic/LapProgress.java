package racingcar.generic;

import java.util.List;
import java.util.stream.Stream;

public record LapProgress(List<RacerProgress> racerProgress) {

    public Stream<RacerProgress> stream() {
        return this.racerProgress().stream();
    }

    public int getBiggestMileage() {
        return racerProgress.stream()
                .mapToInt(RacerProgress::mileage)
                .max().orElse(0);
    }

}
