package racingcar.model.dto;

public class CarDTO {
    private String name;
    private int moveCount;

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
