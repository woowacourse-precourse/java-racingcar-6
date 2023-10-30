package racingcar.circuit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.RacingCar;
import racingcar.domain.result.RacingCarResult;
import racingcar.domain.result.RacingGameStatistics;
import racingcar.generator.NumberGenerator;

public class Circuit {

    private final List<RacingCar> racingCars;
    private final NumberGenerator numberGenerator;

    public Circuit(NumberGenerator numberGenerator) {
        this.racingCars = new ArrayList<>();
        this.numberGenerator = numberGenerator;
    }

    public void addRacingCar(RacingCar racingCar) {
        racingCars.add(racingCar);
    }

    public void tryRacingGame() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(numberGenerator.generate());
        }
    }

    public RacingGameStatistics summarizeRacingResult() {
        List<RacingCarResult> results = racingCars.stream().map(RacingCar::toResult).collect(Collectors.toList());
        return new RacingGameStatistics(results);
    }
}
