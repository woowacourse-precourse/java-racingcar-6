package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.InputValidator.validateRounds;
import static racingcar.InputValidator.validateString;
import static racingcar.constants.PromptMsg.ENTER_CAR_NAME;
import static racingcar.constants.PromptMsg.ENTER_ROUNDS;

public class InputController {
    public InputController() {}

    public String carNamePrompt(){
        System.out.println(ENTER_CAR_NAME);
        String carNamesInput = readLine();
        validateString(carNamesInput);

        return carNamesInput;
    }
    public String roundPrompt(){
        System.out.println(ENTER_ROUNDS);
        String roundsInput = readLine();
        validateRounds(roundsInput);
        return roundsInput;
    }
}
