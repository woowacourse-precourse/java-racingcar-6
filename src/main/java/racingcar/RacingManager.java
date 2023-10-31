package racingcar;

import racingcar.number_generator.NumberGenerator;
import racingcar.number_generator.RandomNumberGenerator;
import racingcar.records.RacingCarSnapshot;
import racingcar.records.RacingHistory;

import java.util.*;

public class RacingManager {
    private final NumberGenerator ng;
    private final List<RacingCar> racingCars;
    private final int moveCount;
    private final List<RacingHistory> racingResult = new ArrayList<>();

    public RacingManager(String carNamesInput, String moveCountInput) {
        this(carNamesInput, moveCountInput, new RandomNumberGenerator());
    }

    public RacingManager(String carNamesInput, String moveCountInput, NumberGenerator ng) {
        this.racingCars = createRacingCars(carNamesInput);
        this.moveCount = parseMoveCountInput(moveCountInput);
        this.ng = ng;
    }

    public void startRace() {
        for (int i = 0; i < moveCount; i++) {
            moveRacingCars();
            addRacingHistory();
        }
    }

    private void moveRacingCars() {
        for (RacingCar racingCar : racingCars) {
            int moveWeight = createMoveWeight();
            racingCar.move(moveWeight);
        }
    }

    private int createMoveWeight() {
        return ng.generate(RacingCar.MIN_MOVE_WEIGHT, RacingCar.MAX_MOVE_WEIGHT);
    }

    private void addRacingHistory() {
        List<RacingCarSnapshot> currentSnapshots = racingCars.stream()
                .map((car) -> new RacingCarSnapshot(car.getName(), car.getForwardCount()))
                .toList();
        RacingHistory history = new RacingHistory(currentSnapshots);

        racingResult.add(history);
    }

    public List<RacingHistory> getRacingResult() {
        return racingResult;
    }

    public List<String> getRacingWinnerNames() {
        int maxMovement = Collections.max(racingCars, Comparator.comparingInt(RacingCar::getForwardCount)).getForwardCount();
        return racingCars.stream()
                .filter(car -> car.getForwardCount() == maxMovement)
                .map(RacingCar::getName)
                .toList();
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public int getMoveCount() {
        return moveCount;
    }

    private List<RacingCar> createRacingCars(String carNamesInput) {
        validateCarNames(carNamesInput);

        String[] carNames = carNamesInput.split(",");
        List<RacingCar> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }
        return racingCars;
    }

    private void validateCarNames(String carNames) {
        if (carNames.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름들을 입력해주세요.");
        }
    }

    private int parseMoveCountInput(String moveCountInput) {
        validateMoveCount(moveCountInput);
        return Integer.parseInt(moveCountInput);
    }

    private void validateMoveCount(String moveCount) {
        if (moveCount.trim().isEmpty()) {
            throw new IllegalArgumentException("시도할 회수를 입력해주세요.");
        }

        try {
            int count = Integer.parseInt(moveCount);
            if (count <= 0) {
                throw new IllegalArgumentException("시도할 회수는 1이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 회수는 숫자여야 합니다.");
        }
    }
}
