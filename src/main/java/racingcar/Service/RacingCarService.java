package racingcar.Service;

import java.util.List;
import racingcar.Model.InputCarNameValidator;
import racingcar.Model.InputCountValidator;
import racingcar.Utils.DtoManager;

public class RacingCarService {
    private static InputCarNameValidator nameValidator = InputCarNameValidator.getInstance();
    private static InputCountValidator countValidator = InputCountValidator.getInstance();
    private static DtoManager dtoManager = new DtoManager();

    public static void userInputRacingCar(String userInput) {
        List<String> validateUserInput = nameValidator.validateNameBeforeSplit(userInput);
        nameValidator.validateNameAfterSplit(validateUserInput);
        dtoManager.setRacingCarDto(validateUserInput);
    }

    public static void userInputCount(String racingCount) {
        int validateRacingCount = countValidator.validateCount(racingCount);
        dtoManager.setRacingCount(validateRacingCount);
    }

    public void play() {
    }
}
