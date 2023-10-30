package racingcar;

import java.util.List;

public class Race {
    private final List<Car> candidates;
    private final int roundNumber;

    public Race(List<String> carNames, int roundNumber) {
        this.candidates = carNames.stream().map(Car::new).toList();
        this.roundNumber = roundNumber;
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
            car.race();
            car.showStatus();
        }
    }
}
