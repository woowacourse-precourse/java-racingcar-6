package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.global.Constants;

import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private InputView() {}

    private static class InputViewCreater {
        private static final InputView INSTANCE = new InputView();
    }

    public static InputView getInstance() {
        return InputViewCreater.INSTANCE;
    }

    public void startGame() {
        List<String> carNames = getCarNames();
    }

    private List<String> getCarNames() {
        String input = inputCarNames();
        List<String> carNames = parseCarNames(input);
        validateCarNames(carNames);
        return carNames;
    }

    private String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private List<String> parseCarNames(String input) {
        List<String> parsedCarNames = List.of(input.split(","));
        return parsedCarNames.stream().map(String::trim).collect(Collectors.toList());
    }

    private void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            validateNotEmpty(carName);
            validateNameLength(carName);
        }
    }

    private void validateNotEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(InputViewException.EMPTY_NAME);
        }
    }

    private void validateNameLength(String carName) {
        if (carName.length() > Constants.MAX_CARNAME_LENGTH) {
            throw new IllegalArgumentException(InputViewException.INVALID_NAME_LENGTH);
        }
    }
}
