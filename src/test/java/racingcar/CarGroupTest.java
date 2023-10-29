package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarGroup;
import racingcar.global.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarGroupTest {
    @Test
    @DisplayName("자동차 이름이 5자리 이상일 경우 예외 발생")
    void fromExceedCarNameLength() {
        assertThatThrownBy(() -> CarGroup.from("pobi,woni,juniper"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.EXCEED_CAR_NAME_LENGTH.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 중복 될 경우 예외 발생")
    void fromDuplicatedCarName() {
        assertThatThrownBy(() -> CarGroup.from("pobi,woni,jun,woni"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATED_CAR_NAME.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 공백일 경우 예외 발생")
    void fromEmptyCarName() {
        assertThatThrownBy(() -> CarGroup.from("pobi,,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.EMPTY_CAR_NAME.getMessage());
    }
}
