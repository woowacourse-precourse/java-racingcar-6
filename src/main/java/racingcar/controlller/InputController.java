package racingcar.controlller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.userInput.CarNamesValidator;
import racingcar.validator.userInput.TotalNumberOfRoundsValidator;
import racingcar.view.InputView;

public class InputController {
    public static String scanCarNames() {
        System.out.println(InputView.enterCarNamesMessage());
        String userInput = Console.readLine();
        CarNamesValidator.getInstance()
                .validate(userInput);
        return userInput;
    }

    public static String scanTotalNumberOfRounds() {
        System.out.println(InputView.enterNumberOfRoundsMessage());
        String userInput = Console.readLine();
        TotalNumberOfRoundsValidator.getInstance()
                .validate(userInput);
        return userInput;
    }
}
