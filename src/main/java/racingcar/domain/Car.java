package racingcar.domain;

public class Car {
    private String name;
    private int move = 0;   //현재 이동한 크기

    public Car(String name) {
        this.name = name;
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
