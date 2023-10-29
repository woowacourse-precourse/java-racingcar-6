package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Validator;

public class InputView {
    public InputView() {
    }

    public static InputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final InputView INSTANCE = new InputView();
    }

    public String getCarNames() {
        String input = readLine();
        Validator.validateCarNames(input);

        return input;
    }

    public int getRounds() {
        String input = readLine();
        Validator.validateRounds(input);

        return Integer.parseInt(input);
    }

    private String readLine() {
        return Console.readLine();
    }
}
