package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {
    private static final String INPUT_NAMES_PATTERN = "^[a-zA-Z가-힣]+(,[a-zA-Z가-힣]+)*$";
    private static ConsoleInputView instance;

    private ConsoleInputView() {}

    public static ConsoleInputView getInstance() {
        if (instance == null) {
            instance = new ConsoleInputView();
        }
        return instance;
    }

    @Override
    public String readCarNames() {
        String names = Console.readLine();
        validateInputNames(names);
        return names;
    }

    @Override
    public int readGameRound() {
        return 0;
    }

    private void validateInputNames(String names) {
        if (isNotNamesPattern(names)) {
            throw new IllegalArgumentException("올바른 이름 형식이 아닙니다. ex) jun,pobi,woni");
        }
    }

    private boolean isNotNamesPattern(String names) {
        return !names.matches(INPUT_NAMES_PATTERN);
    }
}
