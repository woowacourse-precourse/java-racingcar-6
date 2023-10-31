package racingcar.car;

import racingcar.io.ConsoleOutput;

public class Car {

    private final String name;
    private String progress;

    public Car(String name) {
        this.name = name;
        this.progress = "";
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
        ConsoleOutput.print(String.format("%s : %s", this.name, this.progress));
    }

    public String getName() {
        return name;
    }

    public String getProgress() {
        return progress;
    }
}
