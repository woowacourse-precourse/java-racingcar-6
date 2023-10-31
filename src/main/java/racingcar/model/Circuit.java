package racingcar.model;

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

        return roundResult + "\n\n";
    }

    public RaceResult report() {
        RaceResult result = new RaceResult();

        for (RacingCar racingCar : racingCars) {
            result.report(racingCar);
        }

        return result;
    }
}
