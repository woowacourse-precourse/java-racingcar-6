package racingcar.Service;

import java.util.List;
import racingcar.Dto.CarDto;
import racingcar.Model.InputCarNameValidator;
import racingcar.Model.InputCountValidator;
import racingcar.Model.RandomPickNumber;
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

    public void initGame() {
        for (int i = 0; i < dtoManager.getRacingCarCount(); i++) {
            dtoManager.newRacingCar(dtoManager.getRacingCarDto().get(i));
//            System.out.println(dtoManager.getCarDtoList().get(i).getCarName());
//            System.out.println(dtoManager.getCarDtoList().get(i).getPosition());
        }
    }

    public void play() {
        // dto 마다 다르게
        int randomNumber = RandomPickNumber.getRandomPickNumber();
    }
}
