package racingcar.domain;

public class Car implements Comparable<Car> {
    private String name;
    private int progress;

    public Car(String name) {
        this.name = name;
        this.progress = 0;
    }

    void judgmentCarMove(int random) {
        if (random >= 4) {
            progress++;
        }
    }

    public String getName() {
        return name;
    }

    public boolean isSameProgress(Car other) {
        return other.progress == this.progress;
    }

    public String getNameAndProgress() {
        return name + " : " + "-".repeat(progress);
    }

    @Override
    public int compareTo(Car other) {
        return this.progress - other.progress;
    }
}
