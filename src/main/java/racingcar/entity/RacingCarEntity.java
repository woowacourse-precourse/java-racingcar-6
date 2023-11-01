package racingcar.entity;

public class RacingCarEntity {
    private String name;
    private Integer moveCount;

    public RacingCarEntity(String name, Integer moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    public String getName() {
        return name;
    }

    public Integer getMoveCount() {
        return moveCount;
    }

    public void oneMove() {
        this.moveCount += 1;
    }
}
