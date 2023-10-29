package racingcar.view;

import static racingcar.constant.CarConstant.MAX_MOVE_COUNT;
import static racingcar.constant.CarConstant.MAX_NAME_SIZE;
import static racingcar.constant.CarConstant.MIN_MOVE_COUNT;
import static racingcar.constant.CarConstant.MIN_NAME_SIZE;
import static racingcar.constant.CarConstant.NAME_REGEX;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.dto.CarNames;
import racingcar.dto.MoveCount;
import racingcar.validator.Validator;

/*
 *   사용자의 입력을 담당
 * */
public class InputView {
    private static final int SIZE_ZERO = 0;

    public CarNames carNames() {
        String input = Console.readLine();
        List<String> carNames = Arrays.stream(input.split(",")).toList();
        validateCarNames(carNames);
        return CarNames.from(carNames);
    }

    private void validateCarNames(List<String> carNames) {
        Validator.commandsSizeBiggerThan(SIZE_ZERO, carNames);
        Validator.commandsLengthInRange(carNames, MIN_NAME_SIZE, MAX_NAME_SIZE);
        Validator.commandsFollowRegex(carNames, NAME_REGEX);
        Validator.commandsNotDuplicated(carNames);
    }

    public MoveCount moveCount() {
        String input = Console.readLine();
        Validator.commandToInteger(input);
        int moveCount = Integer.parseInt(input);
        Validator.commandValueInRange(moveCount, MIN_MOVE_COUNT, MAX_MOVE_COUNT);
        System.out.println();
        return new MoveCount(moveCount);
    }
}
