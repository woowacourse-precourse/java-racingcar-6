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
        final String[] carNames = console.inputNames();
        final int count = console.inputAttemptCount();
        race.addCarToRace(carNames);

        for (int i = 0; i < count; i++) {
            race.startOneLap();
            final String lapResult = race.getLapResult();
            console.oneLapResultPrint(lapResult);
        }

        final String finalWinningCarNames = race.getFinalWinningCarNames();
        System.out.println("최종 우승자 : " + finalWinningCarNames);
    }

}
