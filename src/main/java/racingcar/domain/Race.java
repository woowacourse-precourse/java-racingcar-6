package racingcar.domain;

import racingcar.NumberGenerator;
import racingcar.RandomNumberGenerator;
import racingcar.domain.Car;

import java.util.List;

public class Race {
    private final List<Car> candidates;
    private final int roundNumber;
    private final NumberGenerator numberGenerator;

    public Race(List<String> carNames, int roundNumber) {
        this.candidates = carNames.stream().map(Car::new).toList();
        this.roundNumber = roundNumber;
        this.numberGenerator = new RandomNumberGenerator();
    }

    public Race(List<String> carNames, int roundNumber, NumberGenerator numberGenerator) {
        this.candidates = carNames.stream().map(Car::new).toList();
        this.roundNumber = roundNumber;
        this.numberGenerator = numberGenerator;
    }

    public void play() {
        System.out.println("실행 결과");
        for (int round = 0; round < roundNumber; round++) {
            playOneRound();
            System.out.println();
        }
    }

    private void playOneRound() {
        for (Car car : candidates) {
            int conditionNumber = numberGenerator.generateNumberRange(0, 9);
            car.moveOrStop(conditionNumber);
            car.showStatus();
        }
    }
}
