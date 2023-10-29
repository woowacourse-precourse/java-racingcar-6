package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarNameTest {
    @Test
    void CarName_생성_성공_테스트() {
        // given
        String name = "pobi";
        //when
        CarName carName = new CarName(name);
        //then
        assertThat(carName.getName()).isEqualTo(name);
    }

    @Test
    void CarName_생성_실패_테스트() {
        // given
        String name = "javaji";
        //when
        //then
        assertThatThrownBy(() -> new CarName(name))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }
}