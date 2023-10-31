package racingcar;

import java.util.List;
import racingcar.io.ConsoleProcessor;
import racingcar.model.LoopCount;
import racingcar.model.vo.CarList;

public class RacingGame {

    private final ConsoleProcessor consoleProcessor;
    private final RaceSteward raceSteward;
    private final GameRound gameRound;

    public RacingGame() {
        this.consoleProcessor = new ConsoleProcessor();
        this.raceSteward = new RaceSteward();
        this.gameRound = new GameRound(consoleProcessor);
    }

    protected void hostGame() {
        final String[] carNames = consoleProcessor.getCarNames();
        String loopCountValue = consoleProcessor.getLoopCount();

        final CarList cars = CarList.registerCars(carNames);
        final LoopCount loopCount = LoopCount.of(loopCountValue);

        CarList result = gameRound.playGame(cars, loopCount);

        List<String> winners = raceSteward.nominateWinners(result);
        consoleProcessor.printWinners(winners);

        consoleProcessor.closeConsole();
    }

}
