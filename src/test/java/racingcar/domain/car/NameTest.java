package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorMessage;

public class NameTest {

    @Test
    void 차이름의_길이가_6_이상일_경우_에러_메시지_반환() {
        String carName = "abcdef";
        assertThatThrownBy(() -> new Name(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CAR_NAME_MAX_LENGTH);
    }

    @Test
    void 차이름의_길이가_0_일_경우_에러_메시지_반환() {
        String carName = "";
        assertThatThrownBy(() -> new Name(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CAR_NAME_MIN_LENGTH);
    }

    @Test
    void 차이름의_길이가_5_이하일_경우_이름_보관() {
        String carName = "abcde";
        Name name = new Name(carName);
        assertThat(name.getValue()).isEqualTo(carName);
    }

}
