package racingcar;

public class Car implements Comparable<Car> {
    private String name;
    private Integer score;

    public Car(String name) {
        this.name = name;
        this.score = 0;
    }

    public void move(Judge judge) {
        if (judge.isMoveAvailable()) {
            this.score += 1;
        }
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return name + " : " +
                "-".repeat(score);
    }

    @Override
    public int compareTo(Car o) {
        return getScore() - o.getScore();
    }

    public String getName() {
        return name;
    }
}
