package racingcar.view;

import static racingcar.constant.ExceptionMessage.*;
import static racingcar.constant.RaceIOMessage.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView { // 입력 관련 기능 수행

    public String inputCarName() {
        System.out.println(CAR_NAME_INPUT);
        String nameInput = Console.readLine();
        validateInputBlank(nameInput);
        return nameInput;
    }

    public String inputRounds() {
        System.out.println(ROUNDS_INPUT);
        String roundsInput = Console.readLine();
        validateInputBlank(roundsInput);
        return roundsInput;
    }

    // 빈 문자열 입력 여부 검사용 메소드
    // inputCarName(), inputRound()에서 공통으로 수행하는 유효성 검사
    // 따라서 Validation 클래스가 아닌 InputView 클래스의 메소드로 취급
    public void validateInputBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT);
        }
    }
}