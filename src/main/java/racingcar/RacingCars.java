package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCars = new ArrayList<>();

    public RacingCars(String nameInput) {
        String[] carNames = nameInput.split(",", -1);

        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName.trim()));
        }
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }

    public int size() {
        return racingCars.size();
    }

    public void moveCars(List<Integer> randomNumbers) {
        int index = 0;
        for (RacingCar racingCar : racingCars) {
            racingCar.move(randomNumbers.get(index));
            index++;
        }
    }

    public List<String> findWinners() {
        RacingCar maxDistanceRacingCar = findMaxDistance();

        return findSameDistanceRacingCar(maxDistanceRacingCar);
    }

    private RacingCar findMaxDistance() {
        return racingCars.stream()
                .max(RacingCar::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("차가 없습니다."));
    }

    private List<String> findSameDistanceRacingCar(RacingCar maxDistanceRacingCar) {
        return racingCars.stream()
                .filter(maxDistanceRacingCar::isSameDistance)
                .map(RacingCar::getName)
                .toList();
    }
}
