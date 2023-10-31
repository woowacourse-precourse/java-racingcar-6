package racingcar;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;

public class RacingCarGame {
    private final int trial;
    private final List<RacingCar> cars;
    private final OutputInterface out;
    private final GameRandom random;

    public RacingCarGame(int trial, String[] names, OutputInterface out, GameRandom random) {
        checkTrial(trial);
        this.trial = trial;
        this.out = out;
        this.random = random;
        cars = createCars(names);
    }

    public void run() {
        IntStream.range(0, trial)
                .forEach(i -> runStage());
        out.printWinners(getWinners());
    }

    private List<String> getWinners() {
        Optional<RacingCar> winner = cars.stream()
                .max(RacingCar.positionComparator);

        out.println(winner.get().getName());

        if (winner.isEmpty()) {
            throw new IllegalStateException("winner가 없습니다.");
        }

        return cars.stream()
                .filter(car -> car.isSamePositionWith(winner.get()))
                .map(RacingCar::getName)
                .collect(toList());
    }

    private List<RacingCar> createCars(String[] names) {
        checkNames(names);

        return Arrays.stream(names)
                .map(RacingCar::new)
                .collect(toList());
    }

    private void runStage() {
        cars.stream()
                .forEach(car -> {
                    car.tryForward(random.randomNumberRange(0, 10));
                });
        out.printStage(this);
    }


    private static void checkTrial(int trial) {
        if (trial <= 0) {
            throw new IllegalArgumentException("시도횟수는 1 이상의 값이여야 합니다.");
        }
    }

    private static void checkNames(String[] names) {
        Set<String> carSet = new HashSet<>();

        for (String name : names) {
            if (carSet.contains(name)) {
                throw new IllegalArgumentException("자동차의 이름이 중복됩니다.: " + name);
            }
            carSet.add(name);
        }
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(car -> car.toString())
                .collect(joining("\n"));
    }
}
