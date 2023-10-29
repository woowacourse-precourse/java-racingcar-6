package racingcar.view;

import java.util.List;
import racingcar.constant.GameConstants;
import racingcar.validator.Validator;

import static camp.nextstep.edu.missionutils.Console.*;

public class CarRaceGameView {
    private static CarRaceGameView carRaceGameView = null;

    public static CarRaceGameView getCarRaceGameView() {
        if(carRaceGameView == null){
            carRaceGameView = new CarRaceGameView();
        }
        return carRaceGameView;
    }

    public String startGameView() {
        System.out.println(GameConstants.START_GAME);
        String carNames = readLine();
        Validator.carNamesComma(carNames);


        return carNames;
    }

    public String attemptNumberView() {
        System.out.println(GameConstants.ATTEMPT_NUMBER);
        String attemptNumberString = readLine();
        Validator.isNull(attemptNumberString);
        Validator.isNumber(attemptNumberString);
        Validator.attemptNumberRange(attemptNumberString);

        return attemptNumberString;
    }
}
