package racingcar.domain;

public class Car {
    private String name;
    private int move;
    private int win;


    public Car(String name) {
        this.name = name;
        this.move = 0;
        this.win = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }
}
