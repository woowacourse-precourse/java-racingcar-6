package racingcar.service;

import static java.util.stream.Collectors.joining;

import java.util.stream.IntStream;
import racingcar.domain.Car;

public class StringAssembler {

    public static String assembleRaceProgress(Car car) {
        return car.getNameToString() + " : " + parseProgressBar(car.getProgressToInt());
    }

    private static String parseProgressBar(Integer progress) {
        return IntStream.range(0, progress)
                .mapToObj(i -> "-")
                .collect(joining());
    }
}
