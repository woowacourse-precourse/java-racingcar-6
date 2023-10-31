package racingcar.model;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import racingcar.util.RandomGenerator;

public class Circuit {

    private static final String DELIMITER = "\n";
    private final List<RacingCar> racingCars;

    public Circuit(List<String> entries) {
        this.racingCars = entries.stream()
                .map(RacingCar::new)
                .toList();
    }

    public Circuit(Map<String, Integer> entries) {
        this.racingCars = entries.keySet()
                .stream()
                .map(entry -> new RacingCar(entry, entries.get(entry)))
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
