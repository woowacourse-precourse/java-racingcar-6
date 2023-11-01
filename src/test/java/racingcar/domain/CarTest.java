package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {
    @Test
    @DisplayName("Car를 생성할 수 있다.")
    void carTest() {
        Name woo = new Name("woo");
        Car car = new Car(woo);

        assertThat(car.getName()).isEqualTo(woo.name());
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("Car의 이동 횟수만큼 문자로 변환할 수 있다.")
    void carToStringTest() {
        Name woo = new Name("woo");
        Car car = new Car(woo);
        car.move();
        car.move();
        car.move();

        String movement = car.toString();

        assertThat(movement).isEqualTo("---");
    }
}
