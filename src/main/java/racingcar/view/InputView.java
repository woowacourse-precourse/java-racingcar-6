package racingcar.view;


import static racingcar.constant.CarConstant.CAR_NAME_REGEX;
import static racingcar.constant.CarConstant.MAX_CAR_SIZE;
import static racingcar.constant.CarConstant.MIN_CAR_SIZE;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.validator.Validator;

/*
 *   사용자의 입력을 담당
 * */
public class InputView {

    public List<String> carNames() {
        String input = Console.readLine();
        //, 나누기 테스트 해보기
        List<String> carNames = Arrays.stream(input.split(",")).toList();
        validateCarNames(carNames);
        return carNames;
    }

    private void validateCarNames(List<String> carNames) {
        Validator.stringsLengthInRange(carNames, MIN_CAR_SIZE, MAX_CAR_SIZE);
        Validator.stringsContainsOnlyRegex(carNames, CAR_NAME_REGEX);
        Validator.stringsNotDuplicated(carNames);
    }
    //커밋하고 테스트 하고 체크리스트
}
