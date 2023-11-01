package racingcar;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Game;
import racingcar.message.ValidateErrorMessage;

public class GameValidateTest {

    @Test
    @DisplayName("자동차 이름 길이가 6 이상일 경우, 예외 발생")
    void 이름길이초과_에러(){
        Assertions.assertThatThrownBy(() ->
                new Game(Arrays.asList("pobigjek","crong","jun"), 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ValidateErrorMessage.NAME_LENGTH_ERROR);
    }
}
