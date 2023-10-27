package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.Constants.*;
import static racingcar.constant.Constants.ERROR_INVALID_REPEAT_COUNT;

public class InputView {
    public List<String> getCarsName() {
        System.out.println(INPUT_CARS);
        return validCarNames(Console.readLine());
    }

    public int getRepeatCount() {
        System.out.println(INPUT_REPEAT_COUNT);
        return validRepeatCount(Console.readLine());
    }

    private List<String> validCarNames(String input) {
        String[] carNames = input.split(INPUT_SPLIT_STRING);
        List<String> names = new ArrayList<>();

        for (String carName : carNames) {
            if (NAMES_MAX_LENGTH < carName.length())
                throw new IllegalArgumentException(ERROR_INVALID_CAR_NAME);
            names.add(carName);
        }
        return names;

    }

    private int validRepeatCount(String input) {
        try {
            int repeatCnt = Integer.parseInt(input);
            if (repeatCnt <= MIN_REPEAT_CNT || MAX_REPEAT_CNT < repeatCnt)
                throw new IllegalArgumentException(ERROR_INVALID_REPEAT_COUNT);

            return repeatCnt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_REPEAT_COUNT);
        }
    }

}
