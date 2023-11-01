package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.validator.InputValidator;

public class InputView {

    public static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";

    public Cars inputCars() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String input = readLine().trim();

        InputValidator.validateNotInputComma(input);
        InputValidator.validateInputCarNameCharacter(input);
        InputValidator.validateInputCarNameCount(input);
        InputValidator.validateInputCarNameLength(input);
        InputValidator.validateDuplicationCarNames(input);

        return convertToCars(input);
    }

    public int inputRound() {
        System.out.println(INPUT_ROUND_MESSAGE);
        String input = readLine().trim();

        InputValidator.validateInputRoundCharacter(input);
        InputValidator.validateInputRoundZero(input);

        return Integer.parseInt(input);
    }

    private Cars convertToCars(final String input) {
        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        return new Cars(carNames);
    }
}
