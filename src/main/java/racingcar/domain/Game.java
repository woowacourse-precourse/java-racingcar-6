package racingcar.domain;

public class Game {
    private final Printer printer;

    public Game() {
        printer = new Printer();
    }

    public void start() {
        printer.printStartMessage();
    }
}
