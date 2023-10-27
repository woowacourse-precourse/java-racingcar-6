package racingcar.view;

import static racingcar.constant.CarConstant.MAX_MOVE_COUNT;
import static racingcar.constant.CarConstant.MAX_NAME_SIZE;
import static racingcar.constant.CarConstant.MIN_MOVE_COUNT;
import static racingcar.constant.CarConstant.MIN_NAME_SIZE;
import static racingcar.constant.CarConstant.NAME_REGEX;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.validator.Validator;

/*
 *   사용자의 입력을 담당
 * */
public class InputView {
    private static final int SIZE_ZERO = 0;

    public List<String> carNames() {
        String input = Console.readLine();
        //, 나누기 테스트 해보기
        List<String> carNames = Arrays.stream(input.split(",")).toList();
        validateCarNames(carNames);
        return carNames;
    }

    private void validateCarNames(List<String> carNames) {
        Validator.stringsSizeBiggerThan(SIZE_ZERO, carNames);
        Validator.stringsLengthInRange(carNames, MIN_NAME_SIZE, MAX_NAME_SIZE);
        Validator.stringsContainsOnlyRegex(carNames, NAME_REGEX);
        Validator.stringsNotDuplicated(carNames);
    }

    public int moveCount() {
        String input = Console.readLine();
        Validator.stringToInteger(input);
        int moveCount = Integer.parseInt(input);
        Validator.integerInRange(moveCount, MIN_MOVE_COUNT, MAX_MOVE_COUNT);
        return moveCount;
    }
}
