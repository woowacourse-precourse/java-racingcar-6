package racingcar;

import racingcar.dto.OutputDTO;

public class Car {
    private final String name;
    private int moveCount = 0;

    public Car(String name) {
        this.name = name;
    }

    public void increaseMoveCount() {
        moveCount++;
    }

    public OutputDTO toDTO() {
        return new OutputDTO(name, moveCount);
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
