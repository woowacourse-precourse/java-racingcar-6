package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.exception.ErrorMessage.NOT_INTEGER;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.exception.RacingGameException;

public class InputView {

    private static final String CARS_SPLIT_STRING = ",";
    private static final Pattern NUMBER = Pattern.compile("[0-9]+");
    private static final String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(%s) 기준으로 구분)\n";

    private static final String ASK_ROTATE_NUMBER = "시도할 회수는 몇회인가요?";

    public List<String> enterCarNames() {
        System.out.printf(ENTER_CAR_NAMES, CARS_SPLIT_STRING);

        return toStringList(readLine());
    }

    private static List<String> toStringList(String input) {
        return Arrays.stream(input.split(CARS_SPLIT_STRING))
                .toList();
    }

    public Integer enterRotateNumber() {
        System.out.println(ASK_ROTATE_NUMBER);

        return convertToInteger(readLine());
    }

    private Integer convertToInteger(final String inputNumberString) {
        validateNumber(inputNumberString);

        return Integer.valueOf(inputNumberString);
    }

    private void validateNumber(final String inputNumberString) {
        if (isNotNumber(inputNumberString)) {
            throw RacingGameException.of(NOT_INTEGER);
        }

    }

    private boolean isNotNumber(final String inputNumberString) {
        Matcher matcher = NUMBER.matcher(inputNumberString);

        return !matcher.matches();
    }

}
