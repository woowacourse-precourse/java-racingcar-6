package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {
    private static final String INPUT_NAMES_PATTERN = "^[a-zA-Z가-힣]+(,[a-zA-Z가-힣]+)*$";
    private static final int MINIMUM_ROUND_RANGE = 1;
    private static final int MAXIMUM_ROUND_RANGE = 10;
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
        String round = Console.readLine();
        validateInputRound(round);
        return Integer.parseInt(round);
    }

    private void validateInputNames(String names) {
        if (isNotNamesPattern(names)) {
            throw new IllegalArgumentException("올바른 이름 형식이 아닙니다. ex) jun,pobi,woni");
        }
    }

    private boolean isNotNamesPattern(String names) {
        return !names.matches(INPUT_NAMES_PATTERN);
    }

    private void validateInputRound(String round) {
        if (isNotDigit(round)) {
            throw new IllegalArgumentException("숫자의 형식이 아닙니다.");
        }
        if (isNotValidRange(Integer.parseInt(round))) {
            throw new IllegalArgumentException("횟수는 2이상 10이하만 입력할 수 있습니다.");
        }
    }

    private boolean isNotDigit(String round) {
        try {
            Integer.parseInt(round);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    private boolean isNotValidRange(int round) {
        return round < MINIMUM_ROUND_RANGE || MAXIMUM_ROUND_RANGE < round;
    }
}
