package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    void Car_다섯자_초과_이름으로_생성() {
        String name = "123456789";
        Assertions.assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Car_다섯자_이하_이름으로_생성() {
        String name = "12345";
        assertDoesNotThrow(() -> new Car(name));
    }

}
