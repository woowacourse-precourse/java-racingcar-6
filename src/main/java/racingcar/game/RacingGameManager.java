package racingcar.game;

import java.util.List;
import racingcar.game.vo.RacingCarNamesInput;
import racingcar.game.vo.TotalTurnInput;
import racingcar.game.vo.TurnResult;
import racingcar.race.Racer;
import racingcar.race.RacerRegistry;
import racingcar.race.RacingTurn;

public class RacingGameManager {

    private final RacingGameScreen racingGameScreen;

    public RacingGameManager(RacingGameScreen racingGameScreen) {
        this.racingGameScreen = racingGameScreen;
    }

    public void run() {
        RacerRegistry<Racer> racerRegistry = new RacerRegistry<>();
        registerRacingCar(racerRegistry);

        RacingTurn totalTurn = inputTotalTurn();
        RacingTurnProcessor<Racer> racingTurnProcessor = new RacingTurnProcessor<>(racerRegistry);
        startRace(racingTurnProcessor, totalTurn);

        showFinalWinners(racingTurnProcessor.getWinners());
    }

    private void registerRacingCar(RacerRegistry<Racer> racerRegistry) {
        RacingCarNamesInput racingCarNamesInput = racingGameScreen.inputRacingCar();
        racerRegistry.addAll(racingCarNamesInput.toRacingCarList());
    }

    private RacingTurn inputTotalTurn() {
        TotalTurnInput totalTurnInput = racingGameScreen.inputTotalTurn();
        return totalTurnInput.toRacingTurn();
    }

    private void startRace(RacingTurnProcessor<Racer> racingTurnProcessor, RacingTurn totalTurn) {
        racingGameScreen.startShowGameResult();

        for (int i = 0; i < totalTurn.getCount(); i++) {
            racingTurnProcessor.progressTurn();

            TurnResult turnResult = new TurnResult(racingTurnProcessor.getTurnResult());
            racingGameScreen.showTurnResult(turnResult);
        }
    }

    private void showFinalWinners(List<String> winnerNames) {
        racingGameScreen.showFinalWinner(winnerNames);
    }
}
