package racingcar.view;

import java.util.Arrays;
import java.util.List;
import racingcar.constant.errorMessage.ErrorMessages;
import racingcar.constant.errorMessage.InvalidArgumentException;
import racingcar.view.reader.DefaultReader;
import racingcar.view.reader.Reader;

public class InputView {

    private static final String PRINT_READ_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PRINT_READ_TRY_NUMBER_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String DELIMITER_COMMA = ",";

    private static final Reader reader = new DefaultReader();

    private InputView() {
    }

    public static List<String> readCarName() {
        System.out.println(PRINT_READ_CAR_NAME_MESSAGE);
        return convertCarName(reader.readLine());
    }

    public static int readGameRound() {
        System.out.println(PRINT_READ_TRY_NUMBER_MESSAGE);
        return convertGameRound(reader.readLine());
    }

    private static List<String> convertCarName(final String input) {
        return Arrays.stream(splitWithComma(input))
                .map(String::trim)
                .toList();
    }

    private static String[] splitWithComma(final String input) {
        return input.split(DELIMITER_COMMA);
    }

    private static int convertGameRound(final String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new InvalidArgumentException(ErrorMessages.ROUND_IS_NOT_NUMERIC);
        }
    }
}
