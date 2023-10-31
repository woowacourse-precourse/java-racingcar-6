package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class InputView {

    public String requestCarNameFromUser() {
        try {
            String input = Console.readLine();
            validateBlankException(input);
            return input;
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다. 자동차 이름을 입력해주세요.");
        }
    }

    public String requestRacingRoundCountFromUser() {
        try {
            String input = Console.readLine();
            validateBlankException(input);
            return input.trim();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다. 시도할 횟수를 입력해주세요.");
        }
    }

    // Console.readLine 은 입력값이 ""에 대한 것만 NoSuchElementException 예외를 던진다.
    private void validateBlankException(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력은 필수 사항 입니다.");
        }
    }
}
