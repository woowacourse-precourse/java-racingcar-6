package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputCarNames() {
        return Console.readLine();
    }

    public static int inputMoveCount() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동 횟수는 정수여야 합니다.");
        }
    }
}
