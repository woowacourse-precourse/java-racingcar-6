package racingcar;

public class Car {
    private String name;
    private Long move;

    public Car(String name) {
        this.name = name;
        move = 0L;
    }

    public String getName() {
        return name;
    }

    public Long getMove() {
        return move;
    }

    public void increaseMove() {
        this.move++;
    }
}
