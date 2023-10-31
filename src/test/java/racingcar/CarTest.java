package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    public void 이름예외처리_TEST() {
        String input = "hansols";
        assertThatThrownBy(()->new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("name is limited to 5 characters");
    }

    @Test
    public void 차량움직임_TEST() {
        Car testCar = new Car("hans");
        testCar.move(1);
        assertThat(testCar.location).isEqualTo(1);
    }

}