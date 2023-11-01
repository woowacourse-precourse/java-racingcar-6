package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.Constants.ErrorMessage.EMPTY_NAME;
import static racingcar.Constants.ErrorMessage.NAME_LEN_MAX;
import static racingcar.Constants.ErrorMessage.NUM_POSITIVE;
import static racingcar.Constants.ErrorMessage.SAME_NAME;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Model.Car;
import racingcar.Model.CarList;
import racingcar.Model.TryNumber;


public class ValidateTest {
    @DisplayName("다섯글자 초과의 이름 입력에 대한 예외처리")
    @Test
    void 이름에_대한_예외_처리_다섯글자초과_이름_입력() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Car("javaji"));
        assertThat(e.getMessage()).isEqualTo(NAME_LEN_MAX.getMessage());
    }

    @DisplayName("빈 아룸애 댜헌 예외처리")
    @Test
    void 이름에_대한_예외_처리_빈_이름_입력() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Car(""));
        assertThat(e.getMessage()).isEqualTo(EMPTY_NAME.getMessage());
    }

    @DisplayName("같은 이름에 대한 예외처리 ")
    @Test
    void 이름에_대한_예외_처리_같은_이름_입력() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new CarList(new String[]{"pobi", "pobi", "jinsu"}));
        assertThat(e.getMessage()).isEqualTo(SAME_NAME.getMessage());
    }
    
    @DisplayName("시도횟수 입력 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "01", "qwe", "!2", "R2", "%$"})
    void 시도횟수_입력_예외_처리(String input) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new TryNumber(input));
        assertThat(e.getMessage()).isEqualTo(NUM_POSITIVE.getMessage());
    }

}
