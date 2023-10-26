package racingcar.Controller;

import java.util.List;
import java.util.regex.Pattern;
import racingcar.Constants;
import racingcar.Util;
import racingcar.View.InputView;

public class InputController {
    private static final Pattern CAR_NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9,]+$");

    public List<String> getCarNames() {
        while (true) {
            String input = InputView.carInput();
            List<String> carNames = processInput(input);
            if (carNames != null) {
                return carNames;
            }
            displayErrorMessage();
        }
    }

    public int getRoundCount(){
        return Integer.parseInt(InputView.roundInput());
    }

    private List<String> processInput(String input) {
        if (isValidCarNamesInput(input)) {
        List<String> carNames = Util.splitString(input, Constants.DELIMITER);
            if (isValidCarNamesList(carNames)) {
                return carNames;
            }
        }
        return null;
    }

    private void displayErrorMessage() {
        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
    }


    private void validateInputIsNotEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력이 없습니다.");
        }
    }

    private void validateInputPattern(String input) {
        if (!CAR_NAME_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("입력에 문자, 숫자, 쉼표 외의 문자가 포함되어 있습니다.");
        }
    }

    private boolean isValidCarNamesInput(String input) {
        validateInputIsNotEmpty(input);
        validateInputPattern(input);
        return true;
    }

    private boolean isValidCarNamesList(List<String> carNames) {
        return !hasEmptyName(carNames) && !hasLongName(carNames) && !Util.hasDuplicates(carNames);
    }

    private boolean hasEmptyName(List<String> carNames) {
        if (carNames.stream().anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException("자동차 이름 길이가 0인 경우가 있습니다.");
        }
        return false;
    }

    private boolean hasLongName(List<String> carNames) {
        if (carNames.stream().anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("자동차 이름 길이가 5자 초과했습니다.");
        }
        return false;
    }
}
