package racingcar.view;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.request.RacingCarNamesDto;
import racingcar.dto.request.TryCountDto;
import racingcar.util.BlankValidator;
import racingcar.util.CommaSeparatedEnglishValidator;
import racingcar.util.DigitsOnlyValidator;

public class InputView {
    private static final String INPUT_RACING_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COMMA_DELIMITER = ",";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String NUMBER_FORMAT_EXCEPTION = "숫자로 변환 가능한 문자만 가능합니다.";

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
        CommaSeparatedEnglishValidator.validate(rawRacingCarNames);
    }

    private List<String> split(String format, String input) {
        return List.of(input.split(format));
    }

    public TryCountDto readTryCount() {
        print(INPUT_TRY_COUNT_MESSAGE);
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
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION);
        }
    }

    private static class LazyHolder {

        private static final InputView INSTANCE = new InputView();

    }
}
