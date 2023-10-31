package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static racingcar.common.MessageType.*;

public class CarTest {

    private Car car;
    private String name;

    @BeforeEach
    void setUp(){
        name = "test";
        car = new Car(name);
    }

    @Test
    void 자동차_현재_위치_출력_테스트() {
        String expected = name + COLON.getMessage();
        assertThat(car.getPositionMessage()).isEqualTo(expected);

        car.go();

        expected += ADVANCE.getMessage();
        assertThat(car.getPositionMessage()).isEqualTo(expected);
    }
}
