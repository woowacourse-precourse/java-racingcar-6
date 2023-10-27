package racingcar;

public class Application {
    public static void main(String[] args) {
        Machines machines = new Machines();
        Lap lap = new Lap();

        machines.showMessage();

        machines.getInput();

        lap.showMessage();
    }
}
