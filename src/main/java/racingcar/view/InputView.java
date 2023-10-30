package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String requestCarNameFromUser() {
        return validate(Console.readLine());
    }

    public String requestRacingRoundCountFromUser() {
        return validate(Console.readLine());
    }

    private String validate(String input) {
        // String 에서 빈 값은 null 이 아니라 "" 빈 공백값으로 치환 되지만, 명시적으로 null 도 체크해준다.
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력은 필수 사항 입니다.");
        }
        return input;
    }
}
