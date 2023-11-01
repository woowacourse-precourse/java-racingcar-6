package racingcar.utility;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.GameManager;
import racingcar.validator.Validator;
import racingcar.view.CarRaceGameView;

public class GameSettingUtility {
    public static List<String> getCarNameListAndValidate() {
        CarRaceGameView.printStartGame();
        String carNames = CarRaceGameView.getInput();
        Validator.checkCarNamesForm(carNames);

        List<String> carNameList = Arrays.stream(carNames.split(",")).toList();
        validateCarName(carNameList);
        return carNameList;
    }

    public static int getGameRoundAndValidate() {
        CarRaceGameView.printGameRoundNumberToRun();
        String gameRoundNumberString = CarRaceGameView.getInput();
        validateGameRoundNumber(gameRoundNumberString);
        return Integer.parseInt(gameRoundNumberString);
    }

    public static void setCarImpls(List<String> carNameList) {
        carNameList.forEach(carName -> GameManager.addCarImpl(new Car(carName)));
    }

    public static void validateCarName(List<String> carNameList) {
        Validator.checkCarNameDuplication(carNameList);
        for (String carName : carNameList) {
            Validator.isLessThanFiveLetter(carName);
            Validator.isEmptyString(carName);
        }
    }

    public static void validateGameRoundNumber(String gameRound) {
        Validator.isEmptyString(gameRound);
        Validator.isNumber(gameRound);
        Validator.isMoreThanOne(gameRound);
    }
}
