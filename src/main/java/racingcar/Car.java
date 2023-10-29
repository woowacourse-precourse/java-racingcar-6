package racingcar;

public class Car {
    private final String name;
    private Integer progress;

    public Car(String name) {
        this.name = name;
        this.progress = 0;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public String getName() {
        return name;
    }

    public Integer getProgress() {
        return progress;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(progress);
    }
}
