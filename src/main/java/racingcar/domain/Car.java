package racingcar.domain;

import racingcar.domain.dto.output.CarDto;
import racingcar.domain.dto.output.WinnerDto;

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

    public void moveBy(MovePossibilityChecker movePossibilityChecker) {
        if (isPossibleToMoveBy(movePossibilityChecker)) {
            position++;
        }
    }

    public CarDto toCarDto() {
        return new CarDto(name, position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public WinnerDto toWinnerDto() {
        return new WinnerDto(name);
    }
}
