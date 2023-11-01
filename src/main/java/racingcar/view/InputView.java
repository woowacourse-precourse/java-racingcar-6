package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.ExceptionResponse;
import racingcar.constant.InformationResponse;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String SEPARATOR = ",";

    private void validateNullAndBlank(String input, ExceptionResponse exceptionResponse) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(exceptionResponse.getMessage());
        }
    }

    public List<String> inputCarNames() {
        System.out.println(InformationResponse.INPUT_CAR_NAMES.getMessage());
        String carNames = Console.readLine();
        validateNullAndBlank(carNames, ExceptionResponse.INPUT_CAR_NAMES);
        return Arrays.stream(carNames.split(SEPARATOR))
                .toList();
    }

    public String inputTrialCount() {
        System.out.println(InformationResponse.INPUT_TRIAL_COUNT.getMessage());
        String trialCount = Console.readLine();
        validateNullAndBlank(trialCount, ExceptionResponse.INPUT_TRIAL_COUNT);
        return trialCount;
    }
}
