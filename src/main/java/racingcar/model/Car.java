package racingcar.model;

public class Car {
    private String name;
    private int move;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
        this.move = 0;
    }

    public Car(String name, int move) {
        this.name = name;
        this.move = move;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public void move() {
        this.move++;
    }
}