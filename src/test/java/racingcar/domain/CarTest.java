package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private String testCarName;

    @BeforeEach
    void setUp() {
        testCarName = "pobi";
    }

    @Test
    void 자동차_생성_테스트() {
        Car testCar = new Car(testCarName);

        assertThat(testCar).isNotNull();
        assertThat(testCar.getName()).isEqualTo("pobi");
        assertThat(testCar.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_전진_테스트() {
        Car testCar = new Car(testCarName);
        testCar.move();

        assertThat(testCar.getName()).isEqualTo("pobi");
        assertThat(testCar.getPosition()).isEqualTo(1);
    }
}