package racingcar.domain;

public class RacingCarGame {
    private Input input;
    private Output output;

    public RacingCarGame() {
        this.input = new ConsoleInput();
        this.output = new ConsoleOutput();
    }

    public void start() {
        output.printCarNamesInputRequest();
        input.getCarNames();
    }
}