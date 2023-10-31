package racingcar;

public class RacingCar {
    private String name;
    private Long move;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMove() {
        return move;
    }

    public void increaseMove() {
        this.move++;
    }
}
