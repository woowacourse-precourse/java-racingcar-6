package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarTest {
    private static final int CANT_GO = 3;
    private static final int CAN_GO = 4;

    @Test
    @DisplayName("시작 스텝이 정상적으로 0인지")
    void 시작_스텝이_정상적으로_0인지() throws Exception {
        //given
        Car car = getCar();
        //when
        int currentStep = car.getCurrentStep();
        //then
        assertThat(currentStep).isEqualTo(0);
    }
    @Test
    @DisplayName("move가 정상적인지")
    void move가_정상적인지() throws Exception {
        //given
        Car car = getCar();
        //when
        car.move();
        //then
        assertThat(car.getCurrentStep()).isEqualTo(1);
    }
    private static Car getCar() {
        return new Car("car");
    }
}
