package racingcar.domain;

import racingcar.NumberGenerator;
import racingcar.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

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

    public List<Car> getCandidates() {
        return candidates;
    }

    public void play() {
        System.out.println("\n실행 결과");
        for (int round = 0; round < roundNumber; round++) {
            playOneRound();
            System.out.println();
        }
    }

    private void playOneRound() {
        for (Car car : candidates) {
            car.moveOrStop(numberGenerator.generateNumberRange(0, 9));
            car.showStatus();
        }
    }

    public void printWinners() {
        List<Car> winners = getWinners();
        StringJoiner joiner = new StringJoiner(", ", "최종 우승자 : ", "");
        winners.forEach(winner -> joiner.add(winner.getName()));
        System.out.println(joiner);
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        int maxStatus = -1;
        for (Car candidate : candidates) {
            int candidateStatus = candidate.getStatus();
            if (candidateStatus > maxStatus) {
                maxStatus = candidate.getStatus();
                winners.clear();
            }
            if (candidateStatus >= maxStatus) {
                winners.add(candidate);
            }
        }
        return winners;
    }
}
