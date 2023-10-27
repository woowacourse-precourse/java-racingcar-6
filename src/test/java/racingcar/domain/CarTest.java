package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void 주사위의_눈금이_4이상이면_전진한다(){
        //given
        Car car = new Car("pobi");
        //when
        car.move(4);
        //then
        Assertions.assertThat(car.getMoveNumber()).isEqualTo(1);
    }

    @Test
    void 주사위의_눈금이_4미만이면_정지한다(){
        //given
        Car car = new Car("pobi");
        //when
        car.move(3);
        //then
        Assertions.assertThat(car.getMoveNumber()).isEqualTo(0);
    }

    @Test
    void 최대이동횟수와_일치하면_true를_반환한다(){
        //given
        Car car = new Car("pobi");
        //when
        car.move(4);
        //then
        Assertions.assertThat(car.isMaxMoveNumber(1)).isTrue();
    }

    @Test
    void 최대이동횟수와_일치하지않으면_false를_반환한다(){
        //given
        Car car = new Car("pobi");
        //when
        car.move(4);
        //then
        Assertions.assertThat(car.isMaxMoveNumber(0)).isFalse();
    }

}