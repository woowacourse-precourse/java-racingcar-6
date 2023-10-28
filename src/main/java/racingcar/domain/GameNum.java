package racingcar.domain;

public class GameNum {
    private static int number = 0;

    public void init(int number) {
        this.number = number;
    }

    public void minus() {
        this.number--;
    }

    public int find() {
        return number;
    }
}
