package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.newInstance("car1");
    }
    
    @Test
    @DisplayName("랜덤값에 의한 전진 또는 정지")
    void 랜덤값으로_전진_또는_정지() throws Exception {
        //given
        //when
        car.dashByRandNum();
        //then
        assertThat(car.getDashNum()).isIn(0, 1);
    }
}