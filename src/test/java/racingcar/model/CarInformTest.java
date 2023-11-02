package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarInformTest {
    private CarInform carInform;

    @BeforeEach
    void setUp() {
        carInform = CarInform.newInstance("car1");
    }

    @Test
    @DisplayName("차 이름 가져오기 테스트")
    void 차_이름_가져오기() throws Exception {
        //given
        //when
        //then
        assertThat(carInform.getCarName()).isEqualTo("car1");
    }

    @Test
    @DisplayName("전진이 잘 되는지에 대한 테스트")
    void 전진이_잘_될까요() throws Exception {
        //given
        //when
        carInform.plusDash();
        //then
        assertThat(carInform.getDashLen()).isEqualTo(1);
    }

    @Test
    @DisplayName("레이싱 결과를 잘 가져오는지에 대한 테스트")
    void 레이싱_결과_테스트() throws Exception {
        //given
        //when
        carInform.plusDash();
        //then
        assertThat(carInform.makeRacingResult())
                .isEqualTo("car1 : -");
    }
}