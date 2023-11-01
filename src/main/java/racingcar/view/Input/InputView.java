package racingcar.view.Input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Car;

import static racingcar.util.PrintMessage.INPUT_CAR_NAME;
import static racingcar.util.PrintMessage.INPUT_TRIAL_NUMBER;

public class InputView {
    private InputParser inputParser;
    private InputValidator inputValidator;

    public InputView(InputParser inputParser, InputValidator inputValidator) {
        this.inputParser = inputParser;
        this.inputValidator = inputValidator;
    }

    public String inputCarName() {
        System.out.println(INPUT_CAR_NAME);
        return Console.readLine();
    }

    public List<Car> convertInputCarName(String input) {
        inputValidator.isNull(input.replace(" ",""));

        return inputParser.convertCarList(input);
    }

    public String inputTrialNumber() {
        System.out.println(INPUT_TRIAL_NUMBER);
        return Console.readLine();
    }
    public int convertInputTrialNumber() {
        String trialNumber = inputTrialNumber();
        inputValidator.validateTrialNumber(trialNumber);

        return inputParser.convertTrialNumber(trialNumber);
    }
}
