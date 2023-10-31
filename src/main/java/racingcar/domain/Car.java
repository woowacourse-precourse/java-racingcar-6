package racingcar.domain;

public class Car {
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

    public int getProgress() {
        return progress;
    }

    public boolean isMoreProgress(int maxProgress) {
        return maxProgress < progress;
    }

    public boolean isMaxProgress(int maxProgress) {
        return maxProgress == progress;
    }

    public String getNameAndProgress() {
        return name + " : " + "-".repeat(progress);
    }
}