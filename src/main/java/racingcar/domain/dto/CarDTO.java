package racingcar.domain.dto;

public class CarDTO {
    private final String name;
    private final int moveCount;

    public CarDTO(String name, int moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
