package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.constant.CarConstant.CAR_NAME_SPLIT_STRING;
import static racingcar.exception.ErrorMessage.NOT_POSITIVE_INTEGER;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.exception.RacingGameException;

public class InputView {

    private static final Pattern ZERO_OR_PASITIVE_NUMBER = Pattern.compile("^[0-9]+$");
    private static final String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(%s) 기준으로 구분)\n";

    private static final String ASK_ROTATE_NUMBER = "시도할 회수는 몇회인가요?";

    public List<String> enterCarNames() {
        System.out.printf(ENTER_CAR_NAMES, CAR_NAME_SPLIT_STRING);

        return toStringList(readLine());
    }

    private List<String> toStringList(final String input) {
        return Arrays.stream(input.split(CAR_NAME_SPLIT_STRING))
                .toList();
    }

    public int enterRotateNumber() {
        System.out.println(ASK_ROTATE_NUMBER);

        return convertToInteger(readLine());
    }

    private int convertToInteger(final String inputNumberString) {
        validateNumber(inputNumberString);

        return Integer.parseInt(inputNumberString);
    }

    private void validateNumber(final String inputNumberString) {
        if (isNotNumber(inputNumberString)) {
            throw RacingGameException.of(NOT_POSITIVE_INTEGER);
        }

    }

    private boolean isNotNumber(final String inputNumberString) {
        Matcher matcher = ZERO_OR_PASITIVE_NUMBER.matcher(inputNumberString);

        return !matcher.matches();
    }

}
