package racingcar.game;

import java.util.Arrays;
import java.util.List;
import racingcar.common.config.RacingCarRule;
import racingcar.game.vo.TurnResult;
import racingcar.racer.RacingCar;
import racingcar.validator.Validator;

public class RacingGameManager {

    private final RacingGameScreen racingGameScreen;

    public RacingGameManager(RacingGameScreen racingGameScreen) {
        this.racingGameScreen = racingGameScreen;
    }

    public void run() {
        RacerRegistry<RacingCar> racerRegistry = registerRacingCar();
        int turnCount = inputTotalTurn();
        RacingGame<RacingCar> racingGame = new RacingGame<>(racerRegistry);
        startRace(racingGame, turnCount);
        announceWinner(racingGame);
    }

    private RacerRegistry<RacingCar> registerRacingCar() {
        String racerInput = racingGameScreen.inputRacer();
        Validator.validateLength(racerInput, RacingCarRule.MAX_RACING_CAR_NAME_INPUT_LENGTH);
        Validator.validateHasText(racerInput);

        String[] split = racerInput.split(RacingCarRule.INPUT_DELIMITER);
        List<RacingCar> list1 = Arrays.stream(split)
                .map(RacingCar::from)
                .toList();

        RacerRegistry<RacingCar> racerRegistry = new RacerRegistry<>();
        racerRegistry.addAll(list1);
        return racerRegistry;
    }

    private int inputTotalTurn() {
        String totalTurn = racingGameScreen.inputTotalTurn();
        Validator.validateLength(totalTurn, RacingCarRule.TOTAL_TURN_INPUT_LENGTH);
        Validator.validateHasText(totalTurn);
        Validator.validateNumeric(totalTurn);
        return Integer.parseInt(totalTurn);
    }

    private void startRace(RacingGame<RacingCar> racingGame, int turnCount) {
        racingGameScreen.startShowGameResult();

        for (int i = 0; i < turnCount; i++) {
            racingGame.progressTurn();

            TurnResult turnResult = new TurnResult(racingGame.getTurnResult());
            racingGameScreen.showTurnResult(turnResult);
        }
    }

    private void announceWinner(RacingGame<RacingCar> racingGame) {
        racingGameScreen.showFinalWinner(racingGame.getWinners());
    }
}
