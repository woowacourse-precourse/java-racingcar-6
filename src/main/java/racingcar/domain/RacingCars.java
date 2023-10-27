package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.constant.MoveStatus;

public final class RacingCars {

    private static final int START_INDEX = 0;
    private static final int MOVE_STANDARD = 4;
    private final List<RacingCar> racingCars;

    public RacingCars(final List<RacingCar> racingCars) {
        this.racingCars = Collections.unmodifiableList(racingCars);
    }

    public int numOfElement() {
        return racingCars.size();
    }

    public void moveByNumbers(final List<Integer> numbers) {
        IntStream.range(START_INDEX, racingCars.size())
                .forEach(i -> move(numbers, i));
    }

    private void move(final List<Integer> numbers, final int index) {
        final RacingCar racingCar = racingCars.get(index);
        final MoveStatus moveStatus = checkMoveStatus(numbers.get(index));
        racingCar.addMoveStatusIfMove(moveStatus);
    }

    private MoveStatus checkMoveStatus(final int number) {
        if (isMovable(number)) {
            return MoveStatus.MOVE;
        }
        return MoveStatus.STOP;
    }

    private boolean isMovable(final int number) {
        return MOVE_STANDARD <= number;
    }
}
