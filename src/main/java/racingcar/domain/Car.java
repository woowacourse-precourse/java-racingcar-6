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

    private static boolean isPossibleToMoveBy(MoveChecker moveChecker) {
        return getMoveInstruction(moveChecker).equals(FORWARD);
    }

    private static MoveInstruction getMoveInstruction(MoveChecker moveChecker) {
        return moveChecker.canMove();
    }

    public void moveBy(MoveChecker moveChecker) {
        if (isPossibleToMoveBy(moveChecker)) {
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
