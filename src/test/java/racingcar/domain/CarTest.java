package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차_전진_또는_멈춤_기능테스트")
    void move() {
        //given
        Car car = new Car("judy");
        //when
        car.move(4);
        //then
        assertThat(car.getPosition()).isEqualTo(1);

    }

    @Test
    @DisplayName("자동차_객체_생성_테스트")
    void shouldCreateCar() {
        // Given
        String carName = "judy";
        // When
        Car car = new Car(carName);
        // Then
        assertEquals(carName, car.getName());
        assertEquals(0, car.getPosition());
    }
}