package racingcar.model;

import java.util.List;
import racingcar.util.RandomGenerator;

public class Circuit {
    private final List<RacingCar> racingCars;

    public Circuit(List<String> names) {
        this.racingCars = names.stream()
                .map(RacingCar::new)
                .toList();
    }

    public void race(int round) {
        for (int i = 0; i < round; i++) {
            for (RacingCar racingCar : racingCars) {
                racingCar.move(RandomGenerator.pickNumber());
            }
        }
    }
}
