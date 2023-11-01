package racingcar.domain;

public class Game {
    private final Printer printer;
    private final Player player;
    private final Reader reader;
    private int raceCount;

    public Game() {
        Validator validator = new Validator();
        reader = new Reader(validator);
        printer = new Printer();
        player = new Player(reader);
    }

    public void start() {
        printer.printStartMessage();
        player.createCars();
        printer.printCountMessage();
        readRaceCount();
        printer.printBlankLine();
        race();
    }

    private void readRaceCount() {
        raceCount = reader.readOneNumber();
    }

    private void race() {
        printer.printResultMessage();
        for (int i = 0; i < raceCount; i++) {
            player.moveCars();
            printer.printRaceResult(player.getCars());
            printer.printBlankLine();
        }
    }
}
