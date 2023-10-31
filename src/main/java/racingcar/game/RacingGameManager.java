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
        RacingGame<Racer> racingGame = new RacingGame<>(racerRegistry);
        startRace(racingGame, turnCount);
        announceWinner(racingGame.getWinners());
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

    private void startRace(RacingGame<Racer> racingGame, int turnCount) {
        racingGameScreen.startShowGameResult();

        for (int i = 0; i < turnCount; i++) {
            racingGame.progressTurn();

            TurnResult turnResult = new TurnResult(racingGame.getTurnResult());
            racingGameScreen.showTurnResult(turnResult);
        }
    }

    private void announceWinner(List<String> winnerNames) {
        racingGameScreen.showFinalWinner(winnerNames);
    }
}
