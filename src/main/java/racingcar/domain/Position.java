package racingcar.domain;

public class Position {

    private int num;

    public Position(int num) {
        this.num = num;
    }

    public static Position create(int num) {
        return new Position(num);
    }

    public void plusNum() {
        this.num++;
    }

    public int getNum() {
        return num;
    }
}
