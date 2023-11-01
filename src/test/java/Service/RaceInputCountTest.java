package Service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceInputCountTest {
    @Test
    @DisplayName("레이스 회수 입력값이 숫자가 아니면 예외처리")
    public void CheckInputCountString() {
        //given
        String inputString = "문자열";
        //when

        //then
        Assertions.assertThatThrownBy(() -> numCheck(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 숫자 형식이 아닙니다.");
    }

    private void numCheck(String inputString) {
        try {
            int gameCount = Integer.parseInt(inputString);
            if (gameCount <= 0) {
                throw new IllegalArgumentException("시도할 회수는 0 이하일 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.");
        }
    }
}