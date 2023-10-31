package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingController;
import racingcar.global.Constants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private InputView() {}

    private static class InputViewCreater {
        private static final InputView INSTANCE = new InputView();
    }

    public static InputView getInstance() {
        return InputViewCreater.INSTANCE;
    }

    private final static RacingController racingController = RacingController.getInstance();

    public void startGame() {
        List<String> carNames = getCarNames();
        int tryCount = getTryCount();
        racingController.startRound(carNames,tryCount);
    }

    private List<String> getCarNames() {
        String input = inputCarNames();
        List<String> carNames = parseCarNames(input);
        validateCarNames(carNames);
        return carNames;
    }

    private int getTryCount() {
        String input = inputTryCount();
        validateTryCount(input);
        return Integer.parseInt(input);
    }

    private String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private String inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine().trim();
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
        validateDuplicateName(carNames);
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

    private void validateDuplicateName(List<String> carNames) {
        Set<String> carNamesSet = new HashSet<>(carNames);
        if (carNamesSet.size() != carNames.size()) {
            throw new IllegalArgumentException(InputViewException.DUPLICATED_NAME);
        }
    }

    private void validateTryCount(String tryCount) {
        if (tryCount.isEmpty()) {
            throw new IllegalArgumentException(InputViewException.EMPTY_TRY_COUNT);
        }
        if (!Pattern.matches(Constants.TRY_COUNT_REGEXP, tryCount)) {
            throw new IllegalArgumentException(InputViewException.INVALID_TRY_COUNT);
        }
        if (Integer.parseInt(tryCount) <= 0) {
            throw new IllegalArgumentException(InputViewException.INVALID_TRY_COUNT);
        }
    }
}
