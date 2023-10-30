package racingcar.domain;

public class Position {
    private final static int ADVANCED_STANDARD = 4;
    private int num;

    private Position(int num) {
        this.num = num;
    }

    public static Position create(int num) {
        return new Position(num);
    }

    public void plusNum(int random) {
        if (random >= ADVANCED_STANDARD) {
            num++;
        }
    }

    public int getNum() {
        return num;
    }
}
