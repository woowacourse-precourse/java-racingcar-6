package racingcar;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class RacingCarGame {
    final int trial;
    final List<RacingCar> cars;
    private final OutputInterface out;

    public RacingCarGame(int trial, String[] names, OutputInterface out) {
        checkTrial(trial);
        this.trial = trial;
        this.out = out;
        cars = Arrays.stream(names)
                .map(RacingCar::new)
                .collect(toList());
    }

    public void run() {
        IntStream.range(0, trial)
                .forEach(i -> runStage());
    }

    private void runStage() {
        cars.stream()
                .forEach(car -> {
                    car.tryForward(randomDice());
                });
        out.printStage(this);

    }

    private int randomDice() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private static void checkTrial(int trial) {
        if (trial <= 0) {
            throw new IllegalArgumentException("시도횟수는 1 이상의 값이여야 합니다.");
        }
    }

    @Override
    public String toString(){
      return cars.stream()
              .map(car -> car.toString())
              .collect(joining("\n"));
    }
}
