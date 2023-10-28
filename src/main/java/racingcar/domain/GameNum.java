package racingcar.domain;

public class GameNum {
    private int number = 0;

    public void create(int number) {
        this.number = number;
    }

    public void minus() {
        this.number--;
    }
}
