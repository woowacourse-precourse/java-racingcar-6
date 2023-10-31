package racingcar.game;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import racingcar.common.config.RacingCarRule;
import racingcar.game.vo.RacerPosition;
import racingcar.game.vo.TurnResult;
import racingcar.racer.RacingCar;
import racingcar.validator.Validator;

public class RacingGameManager {

    private final RacingGameScreen racingGameScreen;

    public RacingGameManager(RacingGameScreen racingGameScreen) {
        this.racingGameScreen = racingGameScreen;
    }

    public void run() {
        RacingCarRegistry racingCarRegistry = registerRacingCar();
        int turnCount = inputNumberOfTurns();
        startRace(racingCarRegistry, turnCount);
        announceWinner(racingCarRegistry);
    }

    private RacingCarRegistry registerRacingCar() {
        String racerInput = racingGameScreen.inputRacer();
        Validator.validateLength(racerInput, RacingCarRule.MAX_RACING_CAR_NAME_INPUT_LENGTH);
        Validator.validateHasText(racerInput);

        String[] split = racerInput.split(RacingCarRule.INPUT_DELIMITER);
        List<RacingCar> list1 = Arrays.stream(split)
                .map(RacingCar::nameOf)
                .toList();

        RacingCarRegistry racingCarRegistry = new RacingCarRegistry();
        racingCarRegistry.addAll(list1);
        return racingCarRegistry;
    }

    private int inputNumberOfTurns() {
        String numberOfTurns = racingGameScreen.inputNumberOfTurns();
        Validator.validateLength(numberOfTurns, RacingCarRule.TURN_COUNT_INPUT_LENGTH);
        Validator.validateHasText(numberOfTurns);
        Validator.validateNumeric(numberOfTurns);
        return Integer.parseInt(numberOfTurns);
    }

    private void startRace(RacingCarRegistry racingCarRegistry, int turnCount) {
        racingGameScreen.startShowGameResult();

        List<RacingCar> racingCars = racingCarRegistry.getRacingCars();
        for (int i = 0; i < turnCount; i++) {
            racingCars.forEach(RacingCar::move);

            List<RacerPosition> list = racingCars.stream()
                    .map(racingCar -> new RacerPosition(racingCar.getName(), racingCar.getPosition()))
                    .toList();

            racingGameScreen.showTurnResult(new TurnResult(list));
        }
    }

    private void announceWinner(RacingCarRegistry racingCarRegistry) {
        List<RacingCar> racingCars = racingCarRegistry.getRacingCars();
        Optional<Integer> maxPosition = racingCars.stream()
                .map(RacingCar::getPosition)
                .max(Integer::compareTo);

        List<String> winners = maxPosition.map(max -> racingCars.stream()
                        .filter(racingCar -> racingCar.getPosition() == max)
                        .map(RacingCar::getName)
                        .toList())
                .orElse(Collections.emptyList());

        racingGameScreen.showFinalWinner(winners);
    }
}
