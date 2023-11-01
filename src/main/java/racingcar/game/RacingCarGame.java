package racingcar.game;

import static java.util.stream.Collectors.toList;

import game.Game;
import game.GameRandom;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import racingcar.game.domain.RacingCar;
import racingcar.game.renderer.RacingCarGameRenderer;

public class RacingCarGame implements Game {
    private final InputInterface in;
    private final OutputInterface out;
    private final int maxTrial;
    private final List<RacingCar> cars;
    private final GameRandom random;
    private final RacingCarGameRenderer renderer;
    private int currentTrial = 0;

    public RacingCarGame(InputInterface in, OutputInterface out, GameRandom random, RacingCarGameRenderer renderer) {
        this.in = in;
        this.out = out;
        cars = createCars(in.getNames());
        this.maxTrial = in.getTrial();
        this.random = random;
        this.renderer = renderer;
        checkTrial(maxTrial);
    }

    private List<String> getWinners() {
        RacingCar highest = getCarWithHighestPosition();

        return cars.stream()
                .filter(car -> car.isSamePositionWith(highest))
                .map(RacingCar::getName)
                .collect(toList());
    }

    private RacingCar getCarWithHighestPosition() {
        Optional<RacingCar> highest = cars.stream()
                .max(RacingCar.positionComparator);

        if (highest.isEmpty()) {
            throw new IllegalStateException("winner가 없습니다.");
        }

        return highest.get();
    }

    private List<RacingCar> createCars(String[] names) {
        checkNames(names);

        return Arrays.stream(names)
                .map(RacingCar::new)
                .collect(toList());
    }

    public void runStage() {
        if (isFinished()) {
            return;
        }
        cars.stream()
                .forEach(car -> {
                    car.tryForward(random.randomNumberRange(0, 10));
                });
        currentTrial++;
    }

    @Override
    public void printStage() {
        out.printStage(this);
    }

    @Override
    public void printResult() {
        out.printWinners(getWinners());
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

    public boolean isFinished() {
        return maxTrial <= currentTrial;
    }

    public String render() {
        if (currentTrial == 1) {
            return renderer.renderFirstStage(
                    renderer.renderCars(List.copyOf(cars))
            );
        }
        return renderer.renderCars(List.copyOf(cars));
    }
}
