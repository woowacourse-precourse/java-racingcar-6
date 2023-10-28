package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.generator.NumberGenerator;

public class RaceParticipants {
    private final List<RacingCar> racingCarList = new ArrayList<>();

    public RaceParticipants(String carNames, NumberGenerator numberGenerator) {
        List<String> carNamesList = splitCarNames(carNames);

    }

    private List<String> splitCarNames(String carNames) {
        String[] carNamesArray = carNames.split(",", -1);
        return Arrays.stream(carNamesArray).map(String::trim).toList();
    }
}
