package racingcar.domain;

public class Car {
    private String name;
    private int move;

    public Car(String name, int move) {
        this.name = name;
        this.move = move;
    }

    public String getName() {
        return name;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }
}
