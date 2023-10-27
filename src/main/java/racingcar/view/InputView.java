package racingcar.view;

import static racingcar.model.ExceptionMessage.NUMBER_FORMAT_EXCEPTION_MESSAGE;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.request.RacingCarNamesDto;
import racingcar.dto.request.TryCountDto;
import racingcar.util.BlankValidator;
import racingcar.util.DigitsOnlyValidator;
import racingcar.util.EnglishWithCommaSeparatedValidator;

public class InputView {
    private static final String INPUT_RACING_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COMMA_DELIMITER = ",";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private InputView() {
    }

    public static InputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public RacingCarNamesDto readRacingCarNames() {
        print(INPUT_RACING_CAR_NAMES_MESSAGE);
        String rawRacingCarNames = Console.readLine();
        validateRacingCarNames(rawRacingCarNames);
        List<String> racingCarNames = split(COMMA_DELIMITER, rawRacingCarNames);
        return new RacingCarNamesDto(racingCarNames);
    }

    private void print(String message) {
        System.out.println(message);
    }

    private void validateRacingCarNames(String rawRacingCarNames) {
        BlankValidator.validate(rawRacingCarNames);
        EnglishWithCommaSeparatedValidator.validate(rawRacingCarNames);
    }

    private List<String> split(String format, String input) {
        return List.of(input.split(format));
    }

    public TryCountDto readTryCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        String rawTryCount = Console.readLine();
        printEmptyLine();
        validateTryCount(rawTryCount);
        int tryCount = convertToInt(rawTryCount);
        return new TryCountDto(tryCount);
    }

    private void printEmptyLine() {
        System.out.println();
    }

    private void validateTryCount(String rawTryCount) {
        BlankValidator.validate(rawTryCount);
        DigitsOnlyValidator.validate(rawTryCount);
    }

    private int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private static class LazyHolder {

        private static final InputView INSTANCE = new InputView();

    }
}
