package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.constant.message.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public Integer playCount() {
        String input = Console.readLine();
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.getMessage());
        }
        return Integer.parseInt(input);
    }

    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }



    public List<String> carNameList() {
        String name = Console.readLine();
        return Arrays.asList(name.split(","));
    }
}
