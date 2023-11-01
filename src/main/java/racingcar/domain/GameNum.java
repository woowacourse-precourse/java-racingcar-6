package racingcar.domain;

public class GameNum {
    private static int number = 0;

    public void init(int number) {
        isLessThanOne(number);
        GameNum.number = number;
    }

    private void isLessThanOne(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("게임횟수는 1이상 이여야 합니다.");
        }
    }

    public void minus() {
        number--;
    }

    public boolean isOverZero() {
        return number > 0;
    }

    public int getNumber() {
        return number;
    }
}
