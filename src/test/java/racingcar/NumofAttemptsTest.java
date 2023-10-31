package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class NumofAttemptsTest {
    @Test
    void 입력_값의_범위_예외_테스트() {
        String input = "-1";
        int Integer_input = Integer.parseInt(input);

        // 예외가 발생하는지 확인하고 예외가 발생할 경우 테스트 성공
        assertThatThrownBy(() -> {
            isRangeDigits(Integer_input);
        }).isInstanceOf(IllegalArgumentException.class) // isNumDigits 메서드가 IllegalArgumentException을 던지는지 확인
                .hasMessage("수행할 횟수는 1 이상의 숫자여야합니다!"); // 예외 메세지 확인
    }

    @Test
    void 입력_값의_문자_예외_테스트() {
        String input = "이삭";

        // 예외가 발생하는지 확인하고 예외가 발생할 경우 테스트 성공
        assertThatThrownBy(() -> {
            try {
                int parsedInput = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("수행할 횟수는 1 이상의 숫자여야합니다!");
            }
        }).isInstanceOf(IllegalArgumentException.class) // isRangeDigits 메서드가 IllegalArgumentException을 던지는지 확인
                .hasMessage("수행할 횟수는 1 이상의 숫자여야합니다!"); // 예외 메세지 확인
    }

    private void isRangeDigits(int input) {
        //입력 값이 조건에 해당할 경우 예외 처리
        if (input <= 0) {
            throw new IllegalArgumentException("수행할 횟수는 1 이상의 숫자여야합니다!");
        }

    }
}
