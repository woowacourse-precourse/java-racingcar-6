package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int getAttemptCount() {
        return parseInt(Console.readLine());
    }

    public int parseInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }
}
