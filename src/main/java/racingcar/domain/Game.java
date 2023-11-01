package racingcar.domain;

import java.util.List;

public class Game {
    private final Printer printer;
    private final Player player;
    private final Reader reader;
    private final Referee referee;
    private int raceCount;

    public Game() {
        Validator validator = new Validator();
        reader = new Reader(validator);
        printer = new Printer();
        player = new Player();
        referee = new Referee();
    }

    public void start() {
        printer.printStartMessage();
        List<String> names = reader.readNames();
        player.createCars(names);
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
        List<Car> winners = referee.judgeWinner(player.getCars());
        printer.printWinnerResult(winners);
    }
}
