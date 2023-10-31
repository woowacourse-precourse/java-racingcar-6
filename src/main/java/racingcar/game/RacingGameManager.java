package racingcar.game;

import java.util.List;
import racingcar.game.vo.RacingCarNamesInput;
import racingcar.game.vo.TotalTurnInput;
import racingcar.game.vo.TurnResult;
import racingcar.racer.Racer;
import racingcar.racer.RacerRegistry;

public class RacingGameManager {

    private final RacingGameScreen racingGameScreen;

    public RacingGameManager(RacingGameScreen racingGameScreen) {
        this.racingGameScreen = racingGameScreen;
    }

    public void run() {
        RacerRegistry<Racer> racerRegistry = registerRacingCar();
        int turnCount = inputTotalTurn();
        RacingTurnProcessor<Racer> racingTurnProcessor = new RacingTurnProcessor<>(racerRegistry);
        startRace(racingTurnProcessor, turnCount);
        announceWinner(racingTurnProcessor.getWinners());
    }

    private RacerRegistry<Racer> registerRacingCar() {
        RacingCarNamesInput racingCarNamesInput = racingGameScreen.inputRacingCar();

        RacerRegistry<Racer> racerRegistry = new RacerRegistry<>();
        racerRegistry.addAll(racingCarNamesInput.toRacingCarList());
        return racerRegistry;
    }

    private int inputTotalTurn() {
        TotalTurnInput totalTurnInput = racingGameScreen.inputTotalTurn();
        return totalTurnInput.toInt();
    }

    private void startRace(RacingTurnProcessor<Racer> racingTurnProcessor, int turnCount) {
        racingGameScreen.startShowGameResult();

        for (int i = 0; i < turnCount; i++) {
            racingTurnProcessor.progressTurn();

            TurnResult turnResult = new TurnResult(racingTurnProcessor.getTurnResult());
            racingGameScreen.showTurnResult(turnResult);
        }
    }

    private void announceWinner(List<String> winnerNames) {
        racingGameScreen.showFinalWinner(winnerNames);
    }
}
