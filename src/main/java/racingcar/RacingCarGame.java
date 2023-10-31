package racingcar;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class RacingCarGame implements Game{
    private final int maxTrial;
    private final List<RacingCar> cars;
    private final GameRandom random;
    private int currentTrial = 0;

    public RacingCarGame(String[] names, int maxTrial, GameRandom random) {
        checkTrial(maxTrial);
        this.maxTrial = maxTrial;
        this.random = random;
        cars = createCars(names);
    }
    
    public List<String> getWinners() {
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

    public String render(RacingCarGameRenderer renderer) {
        if (currentTrial == 1) {
            return renderer.renderFirstStage(
                    renderer.renderCars(List.copyOf(cars))
            );
        }
        return renderer.renderCars(List.copyOf(cars));
    }
}
