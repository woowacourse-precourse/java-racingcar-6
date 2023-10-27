package racingcar.component;

public class Car {
    private String name;
    private String progress;

    public Car (String name) {
        this.name = name;
        this.progress = "";
    }

    public String getName() {
        return name;
    }

    public String getProgress() {
        return progress;
    }

    public void go() {
        this.progress += "-";
    }
}
