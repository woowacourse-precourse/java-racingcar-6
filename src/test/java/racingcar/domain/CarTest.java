package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
    private Car testCar;
    private String testCarName;

    @BeforeEach
    void setUp() {
        testCarName = "pobi";
        testCar = new Car(testCarName);
    }

    @Test
    void 자동차_생성_테스트() {
        assertThat(testCar).isNotNull();
        assertEquals(testCarName, testCar.getName());
        assertEquals(0, testCar.getPosition());
    }

    @Test
    void 자동차_전진_테스트() {
        Car testCar = new Car(testCarName);
        testCar.move();
        assertEquals(1, testCar.getPosition());
    }
}