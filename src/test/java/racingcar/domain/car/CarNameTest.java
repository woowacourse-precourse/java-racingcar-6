package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

final class CarNameTest {

    @DisplayName("이름이 1~5자인 자동차 이름 생성 가능")
    @Test
    void createCarNameSuccess() {
        // given
        final String input1 = "1";
        final String input2 = "12345";

        // when
        final CarName carName1 = new CarName(input1);
        final CarName carName2 = new CarName(input2);

        // then
        assertThat(carName1).isEqualTo(input1);
        assertThat(carName2).isEqualTo(input2);

    }

    @DisplayName("이름이 1~5자가 아닌 자동차 이름 생성 시 예외 발생")
    @Test
    void createCarNameFailure() {
        // given
        final String input1 = "";
        final String input2 = "123456";

        // when

        // then
        assertThatThrownBy(() ->
                new CarName(input1))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() ->
                new CarName(input2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}