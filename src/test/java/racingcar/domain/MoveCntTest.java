package racingcar.domain;

import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.ErrorMessage;

@DisplayName("이동 횟수 입력값 테스트")
class MoveCntTest {
    @ParameterizedTest(name="공백 입력 예외 발생")
    @ValueSource(strings = {"", "  "})
    void 공백_입력_예외_발생(String value) {
        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new MoveCnt(value));

        // then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.MOVE_CNT_BLANK);
    }

    @ParameterizedTest(name="숫자 아닌 값 입력 예외 발생 : {0}")
    @ValueSource(strings = {"rr", "3f", "!"})
    void 숫자_아닌_값_입력_예외_발생(String value) {
        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new MoveCnt(value));

        // then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.MOVE_CNT_NOT_NUMBER);
    }

    @ParameterizedTest(name="양수 아닌 수 입력 예외 발생 : {0}")
    @ValueSource(strings = {"0", "-1", "-3456"})
    void 양수_아닌_수_입력_예외_발생(String value) {
        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new MoveCnt(value));

        // then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.MOVE_CNT_NOT_POSITIVE_NUM);
    }

}