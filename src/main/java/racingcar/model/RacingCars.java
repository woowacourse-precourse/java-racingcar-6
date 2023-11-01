package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RacingCars {
    private static final String DUPLICATE_NAME = "중복된 이름이 있습니다.";
    public final String HASH = ",";
    private final List<RacingCar> racingCars;

    private void checkDuplicateNames(List<String> racingCarNames) {
        Set<String> racingCarNameSet = new HashSet<>(racingCarNames);
        if (racingCarNameSet.size() != racingCarNames.size()) throw new IllegalArgumentException(DUPLICATE_NAME);
    }

    public RacingCars (String racingCarNames) {
        List<String> racingCarNameList = splitNameList(racingCarNames);
        checkDuplicateNames(racingCarNameList);
        this.racingCars = racingCarNameList.stream().map(RacingCar::new).collect(Collectors.toList());
    }

    public List<String> splitNameList(String inputRacingCarNames) {
        return List.of(inputRacingCarNames.split(HASH));
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

    public List<String> getRacingCarsStatus() {
        return racingCars.stream()
                .map(RacingCar::getPresentStatus)
                .collect(Collectors.toList());
    }

    public void play(List<Integer> randomNumbers) {
        for (int i = 0; i < racingCars.size(); i++) {
            racingCars.get(i).move(randomNumbers.get(i));
        }
    }

    public int size() {
        return racingCars.size();
    }
}
