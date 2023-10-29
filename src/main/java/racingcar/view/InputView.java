package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public List<String> readUserNameInput() {
        String input = Console.readLine().trim();

        List<String> carNames = splitWordsByDelimiter(input, ",");
        validateCarNames(carNames);

        return carNames;
    }

    private void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            if(!InputValidator.isValidCarNameLength(carName)) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
            }
        }
    }

    public String readUserGameCountInput() {
        String input = Console.readLine().trim();
        if(InputValidator.isNumeric(input)) {
            return input;
        }

        throw new IllegalArgumentException();
    }

    private List<String> splitWordsByDelimiter(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter, -1))
                .map(String::strip)
                .collect(Collectors.toList());
    }
}
