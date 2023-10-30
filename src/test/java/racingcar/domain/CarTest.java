package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car;
    @Test
    void 수가_랜덤_중_4_이상_일_때_직진(){
        int random = 4;
        Car car = new Car();
        int result = car.goForward(random);
        assertThat(result).isEqualTo(1);

    }


}