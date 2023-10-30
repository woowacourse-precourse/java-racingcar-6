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

    public void moveRacingCars() {
        racingCars.forEach(this::moveRacingCarWithRandomNumber);
    }

    private void moveRacingCarWithRandomNumber(RacingCar racingCar) {
        Integer randomNumber = numberGenerator.generate();
        racingCar.move(randomNumber);
    }

    public RacingGameStatistics getRacingGameStatistics() {
        List<RacingCarResult> results = getRacingCarResults();
        return new RacingGameStatistics(results);
    }

    private List<RacingCarResult> getRacingCarResults() {
        return racingCars.stream().map(RacingCar::toResult).collect(Collectors.toList());
    }
}
