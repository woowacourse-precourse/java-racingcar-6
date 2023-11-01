package racingcar.model;

public class Car {
    private final String name;
    private int move;
    private int winCount;

    private Car(String name) {
        this.name = name;
        this.move = 0;
        this.winCount = 0;
    }

    public static Car createCar(String name) {
        return new Car(name);
    }

    public void plusWinCount() {
        this.winCount++;
    }

    public void moveForward(Integer move) {
        this.move = move;
    }

    public Integer getMove() {
        return move;
    }

    public String getName() {
        return name;
    }

    public Integer getWinCount() {
        return winCount;
    }
}
