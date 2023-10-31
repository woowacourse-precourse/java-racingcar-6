package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Model.Car;

public class ValidateTest {
    private static final String NUM_POSITIVE = "시도 횟수는 양의정수만 입력하세요";
    private static final String SAME_NAME = "자동차 이름을 모두 다르게 입력해주세요.";
    private static final String EPTY_NAME = "자동차 이름은 1글자 이상이여야 합니다";
    private static final String NAME_LEN_MAX = "자동차 이름 길이가 5초과 입니다.";

    @DisplayName("다섯글자 초과의 이름 입력에 대한 예외처리")
    @Test
    void 이름에_대한_예외_처리_다섯글자초과_이름_입력() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Car("javaji"));
        assertThat(e.getMessage()).isEqualTo(NAME_LEN_MAX);
    }


    @DisplayName("빈 아룸애 댜헌 예외처리")
    @Test
    void 이름에_대한_예외_처리_빈_이름_입력() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Car(""));
        assertThat(e.getMessage()).isEqualTo(EPTY_NAME);
    }


    @DisplayName("같은 이름에 대한 예외처리 ")
    @Test
    void 이름에_대한_예외_처리_같은_이름_입력() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new CarList(new String[]{"pobi", "pobi", "jinsu"}));
        assertThat(e.getMessage()).isEqualTo(SAME_NAME);
    }


    @DisplayName("시도횟수 입력 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "01", "qwe", "!2", "R2", "%$"})
    void 시도횟수_입력_예외_처리(String input) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new TryNumber(input));
        assertThat(e.getMessage()).isEqualTo(NUM_POSITIVE);
    }

}
