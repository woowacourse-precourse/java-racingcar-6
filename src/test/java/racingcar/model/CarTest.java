package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @DisplayName("전진 테스트")
    @Test
    void canMoveTest() {
        //given
        Car pobi = new Car("pobi");

        //when
        pobi.move();

        //then
        assertThat(pobi.getDistance().toString()).isNotNull(); // 랜덤 테스트 어떻게 짤까?
    }
}