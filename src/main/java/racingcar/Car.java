package racingcar;

public class Car {
    private String name;
    private Long move;

    public Car(String name) {
        this.name = name;
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
