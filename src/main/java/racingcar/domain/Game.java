package racingcar.domain;

public class Game {
    private final Printer printer;
    private final Player player;

    public Game() {
        Validator validator = new Validator();
        Reader reader = new Reader(validator);
        printer = new Printer();
        player = new Player(reader);
    }

    public void start() {
        printer.printStartMessage();
        player.createCars();
        printer.printCountMessage();
    }
}
