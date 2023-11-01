package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 자동차를_새로_생성하면_이동한_거리는_빈칸으로_출력() {
        // given
        Car car = new Car("jiho");

        // then
        Assertions.assertEquals("jiho : ", car.toString());
    }
    
    @Test
    void 자동차를_한번_전진시키면_이동한_거리는_한칸으로_출력() {
        // given
        Car car = new Car("jiho");

        // when
        car.moveForward();

        // then
        Assertions.assertEquals("jiho : -", car.toString());
    }
}
