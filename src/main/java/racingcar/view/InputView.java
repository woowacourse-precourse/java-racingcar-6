package racingcar.view;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.request.RacingCarNamesDto;
import racingcar.util.BlankValidator;
import racingcar.util.EnglishWithCommaSeparatedValidator;

public class InputView {
    private static final String INPUT_RACING_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COMMA_DELIMITER = ",";

    private InputView() {
    }

    public static InputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public RacingCarNamesDto readRacingCarNames() {
        print(INPUT_RACING_CAR_NAMES_MESSAGE);
        String rawRacingCarNames = Console.readLine();
        validate(rawRacingCarNames);
        List<String> racingCarNames = split(COMMA_DELIMITER, rawRacingCarNames);
        return new RacingCarNamesDto(racingCarNames);
    }

    private void print(String message) {
        System.out.println(message);
    }

    private void validate(String rawRacingCarNames) {
        BlankValidator.validate(rawRacingCarNames);
        EnglishWithCommaSeparatedValidator.validate(rawRacingCarNames);
    }

    private List<String> split(String format, String input) {
        return List.of(input.split(format));
    }

    private static class LazyHolder {

        private static final InputView INSTANCE = new InputView();

    }
}
