package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import racingcar.util.RandomGenerator;

public class Circuit {

    private static final String DELIMITER = "\n";
    private final List<RacingCar> racingCars;

    public Circuit(List<String> names) {
        this.racingCars = names.stream()
                .map(RacingCar::new)
                .toList();
    }

    public String race() {
        StringJoiner roundResult = new StringJoiner(DELIMITER);

        for (RacingCar racingCar : racingCars) {
            racingCar.move(RandomGenerator.pickNumber());
            roundResult.add(racingCar.toString());
        }

        return roundResult + "\n";
    }

    public RaceResult report() {
        List<RacingCar> nominees = new ArrayList<>();

        for (RacingCar racingCar : racingCars) {
            nominees = racingCar.compare(nominees);
        }

        return new RaceResult(nominees);
    }
}
