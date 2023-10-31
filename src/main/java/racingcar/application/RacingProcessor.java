package racingcar.application;

import racingcar.domain.FuelFactory;
import racingcar.domain.GameTry;
import racingcar.domain.RacingStadium;
import racingcar.io.OutputProcessor;

public class RacingProcessor {
    private final RacingStadium racingStadium;
    private final GameTry gameTry;
    private final FuelFactory fuelFactory;

    public RacingProcessor(final RacingStadium racingStadium, final GameTry gameTry, final FuelFactory fuelFactory) {
        this.racingStadium = racingStadium;
        this.gameTry = gameTry;
        this.fuelFactory = fuelFactory;
    }

    public void run() {
        racingStart();
        notifyWinners();
    }

    private void racingStart() {
        while (gameTry.isStillCanTry()) {
            racingStadium.racing(fuelFactory);
            OutputProcessor.printRacingRound(racingStadium.getCars());
            gameTry.proceed();
        }
    }

    private void notifyWinners() {
        OutputProcessor.printWinners(racingStadium.getWinners());
    }
}
