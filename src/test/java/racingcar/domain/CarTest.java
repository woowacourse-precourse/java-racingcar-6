package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void Car_다섯자_초과_이름으로_생성() {

        String name = "123456789";

        Assertions.assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);

    }

}
