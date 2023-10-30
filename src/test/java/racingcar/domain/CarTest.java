package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car;
    private static final int MOVE = 4;
    @Test
    void 수가_랜덤_중_4_이상_일_때_직진(){
        Car car = new Car();
        car.goForward(MOVE);
        assertThat(car.getForward()).isEqualTo(1);
    }


}