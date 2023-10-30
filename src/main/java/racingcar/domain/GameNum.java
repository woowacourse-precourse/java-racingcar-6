package racingcar.domain;

public class GameNum {
    private static int number = 0;

    public void init(int number) {
        GameNum.number = number;
    }

    public void minus() {
        number--;
    }

    public boolean isOverZero() {
        return number > 0;
    }
}
