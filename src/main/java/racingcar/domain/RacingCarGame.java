package racingcar.domain;

import racingcar.domain.console.Console;
import racingcar.domain.race.Race;

public class RacingCarGame {
    private final Console console;
    private final Race race;

    private RacingCarGame(final Console console, final Race race) {
        this.console = console;
        this.race = race;
    }

    public static RacingCarGame of(final Console console, final Race race) {
        return new RacingCarGame(console, race);
    }

    public void start() {
        addCarsToRaceFromUserInput();

        final int raceCount = console.inputAttemptCount();

        runRace(raceCount);
        finalResultsPrint();
    }

    private void addCarsToRaceFromUserInput() {
        final String[] carNames = console.inputNames();
        race.addCarToRace(carNames);
    }

    private void runRace(final int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            race.startOneLap();
            final String lapResult = race.getLapResult();
            console.oneLapResultPrint(lapResult);
        }
    }

    private void finalResultsPrint() {
        final String finalWinningCarNames = race.getFinalWinningCarNames();
        console.finalWinnersPrint(finalWinningCarNames);
    }

}
