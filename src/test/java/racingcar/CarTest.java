package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class CarTest {

    @Test
    void 동일한_이름을_가진_차는_동일한_객체로_인식한다() {
        Name sameName = new Name("동일한이름");
        Car car1 = new Car(sameName);
        Car car2 = new Car(sameName);

        assertEquals(car1, car2);
    }

    record Car(Name name) {
    }
}
