package racingcar.game;

import racingcar.io.GameConsoleOutput;

public class Car {

    private final String name;
    private String progress;

    public static Car of(String name, String progress) {
        return new Car(name, progress);
    }

    private Car(String name, String progress) {
        this.name = name;
        this.progress = progress;
    }

    public void forward(int threshold, int number, String command) {
        if (number >= threshold) {
            doForward(command);
        }
    }

    private void doForward(String command) {
        progress += command;
    }

    public void showProgress() {
        GameConsoleOutput.print(String.format("%s : %s", this.name, this.progress));
    }

    public String getName() {
        return name;
    }

    public String getProgress() {
        return progress;
    }
}
