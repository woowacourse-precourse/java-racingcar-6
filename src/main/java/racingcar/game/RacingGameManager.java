package racingcar.game;

import java.util.Arrays;
import java.util.List;
import racingcar.racer.RacingCar;
import racingcar.validator.Validator;

public class RacingGameManager {

    private final RacingGameScreen racingGameScreen;

    public RacingGameManager(RacingGameScreen racingGameScreen) {
        this.racingGameScreen = racingGameScreen;
    }

    public void run() {
        registerRacingCar();
    }

    private void registerRacingCar() {
        String racerInput = racingGameScreen.inputRacer();
        Validator.validateLength(racerInput, 0, 599); //maxLength = 이름 최대 길이 * 이름 최대 개수 + (이름 최대 개수 -1)*구분자 길이
        Validator.validateHasText(racerInput);

        String[] split = racerInput.split(",");
        List<RacingCar> list1 = Arrays.stream(split)
                .map(RacingCar::nameOf)
                .toList();

        RacingCarRegistry racingCarRegistry = new RacingCarRegistry();
        racingCarRegistry.addAll(list1);
    }
}
