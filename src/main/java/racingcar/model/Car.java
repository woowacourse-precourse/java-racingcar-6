package racingcar.model;

public class Car {
    private String name;
    private String move;

    public Car(String name, String move) {
        this.name = name;
        this.move = move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public String getName() {
        return name;
    }

    public String getMove() {
        return move;
    }

    @Override
    public String toString() {
        return name + " : " + move;
    }
}