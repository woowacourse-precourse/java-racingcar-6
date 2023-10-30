package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AttemptsTest {

    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    @DisplayName("시도 횟수 빈 문자열, 공백 들어왔을 때 예외 테스트")
    public void 시도_횟수_입력_예외_테스트(String input) {
        //given
        String attempts = input;

        //when, then
        Assertions.assertThatThrownBy(() -> new Attempts(attempts))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백 혹은 빈");
    }
}
