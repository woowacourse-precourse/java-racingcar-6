package racingcar.domain;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 자동차_이동_테스트(){
        Car car = new Car("자동차1", "");
        car.addScore();
        assertThat(car.getScore()).isEqualTo("-");
    }

}