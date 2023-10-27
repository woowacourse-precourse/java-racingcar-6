package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String BLANK = " ";
    private static final String EMPTY = "";

    public String inputName() {
        return deleteBlank(Console.readLine());
    }

    public String inputTryNumber() {
        return deleteBlank(Console.readLine());
    }

    public String deleteBlank(String input) {
        input.replace(BLANK, EMPTY);
        return input;
    }

}
