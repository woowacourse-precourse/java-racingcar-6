package racingcar.domain;

import racingcar.domain.dto.output.CarDto;

import static racingcar.domain.MoveInstruction.FORWARD;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    private static boolean isPossibleToMoveBy(MovePossibilityChecker movePossibilityChecker) {
        return getMoveInstruction(movePossibilityChecker).equals(FORWARD);
    }

    private static MoveInstruction getMoveInstruction(MovePossibilityChecker movePossibilityChecker) {
        return movePossibilityChecker.canMove();
    }

    public CarDto moveBy(MovePossibilityChecker movePossibilityChecker) {
        if (isPossibleToMoveBy(movePossibilityChecker)) {
            position++;
        }
        return new CarDto(name, position);
    }
}
