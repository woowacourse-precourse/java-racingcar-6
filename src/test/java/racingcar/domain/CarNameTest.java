package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

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
}