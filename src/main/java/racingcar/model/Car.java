package racingcar.model;

public class Car {
    String name;
    int progress;
    StringBuilder dash;

    public Car(String name, int progress) {
        this.name = name;
        this.progress = progress;
        dash = new StringBuilder();
    }

    public void go() {
        progress += 1;
        dash.append("-");
    }

    public String getName() {
        return name;
    }

    public int getProgress() {
        return progress;
    }

    public String getDash() {
        return dash.toString();
    }
}
