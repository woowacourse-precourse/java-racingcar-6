package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.Constants.*;

public class InputView {
    public List<String> getCarsName() {
        System.out.println(INPUT_CARS);
        return extractAndValidateCarNames(Console.readLine());
    }

    public int getRepeatCount() {
        System.out.println(INPUT_REPEAT_COUNT);
        return extractAndValidateRepeatCount(Console.readLine());
    }

    public List<String> extractAndValidateCarNames(String input) {
        validateInput(input);

        String[] carNames = input.split(INPUT_SPLIT_STRING);
        List<String> validCarNames = new ArrayList<>();

        for (String carName : carNames) {
            String trimCarName = carName.trim();
            validateCarName(trimCarName);
            validCarNames.add(trimCarName);
        }

        return validCarNames;
    }

    public int extractAndValidateRepeatCount(String input) {
        try {
            int repeatCnt = Integer.parseInt(input);
            if (repeatCnt <= MIN_REPEAT_CNT || MAX_REPEAT_CNT < repeatCnt)
                throw new IllegalArgumentException(ERROR_INVALID_REPEAT_COUNT);
            return repeatCnt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_REPEAT_COUNT);
        }
    }

    public void validateCarName(String carName) {
        if (isCarNameInvalid(carName)) {
            throw new IllegalArgumentException(ERROR_INVALID_CAR_NAME);
        }
    }

    public boolean isCarNameInvalid(String carName) {
        return carName.length() > NAMES_MAX_LENGTH;
    }

    public void validateInput(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(ERROR_INVALID_CAR_NAME);
        }
    }

}
