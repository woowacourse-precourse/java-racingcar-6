package racingcar;

public class Car {
    private String name;
    private int position;

    public void move() {
        if (GameUtil.shouldMove()) {
            this.position++;
        }
    }

    public String makeMoveResult() {
        StringBuilder result = new StringBuilder();

        result.append(this.name + " : ");
        for (int round = 0; round < this.position; round++) {
            result.append("-");
        }
        return result.toString();
    }
}
