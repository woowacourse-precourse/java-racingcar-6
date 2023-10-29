package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    public void 생성자_이름_조회_테스트() throws Exception {
        String expected = "david";
        Car car = new Car(expected);

        Assertions.assertThat(car.getName()).isEqualTo(expected);
    }

}