package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.CarNameValidator;
import racingcar.validator.MoveNumberValidator;

import java.util.List;

import static racingcar.constant.ConsoleMessage.INPUT_YOUR_CAR_NAMES;
import static racingcar.constant.ConsoleMessage.INPUT_YOUR_TRIAL_COUNT;


public class InputView {

    public List<String> inputCarNames() {
        System.out.println(INPUT_YOUR_CAR_NAMES);
        String input = Console.readLine();

        CarNameValidator.validate(input);

        return convertToCarNameList(input);
    }

    private List<String> convertToCarNameList(String input) {
        String[] carNames = input.split(",");

        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }

        return List.of(carNames);
    }

    public int inputTrialCount() {
        System.out.println(INPUT_YOUR_TRIAL_COUNT);
        String trialCount = Console.readLine();
        MoveNumberValidator.validate(trialCount);
        return Integer.parseInt(trialCount);
    }
}
