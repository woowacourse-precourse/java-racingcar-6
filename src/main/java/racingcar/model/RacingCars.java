package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RacingCars {
    private static final String DUPLICATE_NAME = "중복된 이름이 있습니다.";
    private static final String HASH = ", ";
    private final List<RacingCar> racingCars;

    private void checkDuplicateNames(List<String> racingCarNames) {
        Set<String> racingCarNameSet = new HashSet<>(racingCarNames);
        if (racingCarNameSet.size() != racingCarNames.size()) throw new IllegalArgumentException(DUPLICATE_NAME);
    }

    public RacingCars (List<String> racingCarNames) {
        checkDuplicateNames(racingCarNames);
        this.racingCars = racingCarNames.stream().map(RacingCar::new).collect(Collectors.toList());
    }

    public int getMaxMoveCount() {
        return racingCars.stream()
                .map(RacingCar::getMoveCount)
                .max(Integer::compareTo)
                .orElse(0);
    }

    public List<String> getWinners() {
        int maxMoveCount = getMaxMoveCount();
        return racingCars.stream()
                .filter(racingCar -> racingCar.isWinnerRacingCar(maxMoveCount))
                .map(RacingCar::getRacingCarName).collect(Collectors.toList());
    }

    public String getResult(List<RacingCar> racingCars) {
        List<String> winners = getWinners();
        return String.join(HASH, winners);
    }
}
