package racingcar;

import racingcar.dto.output.RoundResultDTO;

public class Car {
    private final String name;
    private int moveCount = 0;

    public Car(String name) {
        this.name = name;
    }

    public void increaseMoveCount() {
        moveCount++;
    }

    public RoundResultDTO toDTO() {
        return new RoundResultDTO(name, moveCount);
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
