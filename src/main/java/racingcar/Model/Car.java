package racingcar.Model;

public class Car {
    private String name;
    private String progress;
    private int progressCounter;

    public Car(String name) {
        this.name = name;
        this.progress = "";
        this.progressCounter = 0;
    }

    public void setCarName(String input) {
        this.name = input;
    }

    public String getCarName() {
        return this.name;
    }

    public void addProgress() {
        this.progress = this.progress + '-';
        this.progressCounter++;
    }

    public String getProgress() {
        return this.progress;
    }

    public int getProgressCounter() {
        return this.progressCounter;
    }
}
