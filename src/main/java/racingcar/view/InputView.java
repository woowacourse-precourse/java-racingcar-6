package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.Validator;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.Constants.ERROR_INVALID_REPEAT_COUNT;


public class InputView {

    public static final String INPUT_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_REPEAT_COUNT = "시도할 회수는 몇회인가요?";
    public static final String INPUT_SPLIT_STRING = ",";
    private final Validator validator = new Validator();

    public List<String> getCarsName() {
        System.out.println(INPUT_CARS);
        return extractAndValidateCarNames(Console.readLine());
    }

    public int getRepeatCount() {
        System.out.println(INPUT_REPEAT_COUNT);
        return extractAndValidateRepeatCount(Console.readLine());
    }

    public List<String> extractAndValidateCarNames(String input) {
        validator.validateInput(input);

        String[] carNames = input.split(INPUT_SPLIT_STRING);
        List<String> validCarNames = new ArrayList<>();

        for (String carName : carNames) {
            String trimCarName = carName.trim();
            validator.validateCarName(trimCarName);
            validCarNames.add(trimCarName);
        }

        return validCarNames;
    }

    public int extractAndValidateRepeatCount(String input) {
        try {
            int repeatCnt = Integer.parseInt(input);
            validator.validRepeatCnt(repeatCnt);
            return repeatCnt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_REPEAT_COUNT);
        }
    }

}
