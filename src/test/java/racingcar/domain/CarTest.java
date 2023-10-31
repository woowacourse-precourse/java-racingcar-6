package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private static final int DEPART_NUM = 4;
    private Car car;
    @Test
    void 수가_랜덤_중_4_이상_일_때_직진(){
        Car car = new Car("pobi");
        car.goForward(DEPART_NUM);
        assertThat(car.getForward()).isEqualTo(1);
    }


}