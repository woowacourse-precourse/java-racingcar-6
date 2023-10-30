package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> insertCarName() {
        String input = Console.readLine();
        List<String> names = toStringList(input);
        return names;
    }

    public List<String> toStringList(String name) {
        List<String> names = Arrays.asList(name.split(","));
        validateName(names);
        return names;
    }

    public void validateName(List<String> names) {
        if (!isAllFiveOrLess(names)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이내로 입력해주세요.");
        }
    }

    public boolean isAllFiveOrLess(List<String> names) {
        for (String name : names) {
            if (name.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public int insertRoundNumber() {
        String input = Console.readLine();
        validateNumber(input);

        return convertToNumber(input);
    }

    public void validateNumber(String input) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException("숫자를 입력하세요");
        }
    }

    public boolean isNumber(String input) {
        return input.matches("^[0-9]*$");
    }

    public int convertToNumber(String input) {
        return Integer.parseInt(input);
    }
}
