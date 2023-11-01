package racingcar.game;

import java.util.List;
import racingcar.domain.RacerRegistry;
import racingcar.domain.RacingTurn;
import racingcar.domain.racer.Racer;
import racingcar.game.vo.RacingCarNamesInput;
import racingcar.game.vo.TotalTurnInput;

public class RacingGameManager {

    private final RacingGameScreen racingGameScreen;
    private final RacerRegistry<Racer> racerRegistry = new RacerRegistry<>();

    public RacingGameManager(RacingGameScreen racingGameScreen) {
        this.racingGameScreen = racingGameScreen;
    }

    public void run() {
        try {
            registerRacingCar();
            RacingTurn totalTurn = getTotalTurn();
            showFinalWinners(race(totalTurn));
        } catch (Exception e) {
            racingGameScreen.showError(e.getMessage());
            throw e;
        } finally {
            racerRegistry.clear();
            racingGameScreen.close();
        }
    }

    private void registerRacingCar() {
        RacingCarNamesInput racingCarNamesInput = racingGameScreen.inputRacingCarNames();
        racerRegistry.addAll(racingCarNamesInput.toRacingCarList());
    }

    private RacingTurn getTotalTurn() {
        TotalTurnInput totalTurnInput = racingGameScreen.inputTotalTurn();
        return totalTurnInput.toRacingTurn();
    }

    private List<String> race(RacingTurn totalTurn) {
        racingGameScreen.startShowGameResult();

        RacingTurnProcessor<Racer> racingTurnProcessor = new RacingTurnProcessor<>(racerRegistry);
        for (int i = 0; i < totalTurn.getCount(); i++) {
            racingTurnProcessor.progressTurn();
            racingGameScreen.showTurnResult(racingTurnProcessor.getRacerPositions());
        }

        return racingTurnProcessor.getWinners();
    }

    private void showFinalWinners(List<String> winnerNames) {
        racingGameScreen.showFinalWinner(winnerNames);
    }
}
