package racingcar.domain;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    private Car car;

    @BeforeEach
    void beforeEach() {
        car = Car.createCar("BMW");
    }

    @Test
    @DisplayName("위치 객체 생성 후 direction이랑 position 확인")
    public void createPosition() {
        // Given
        StringBuilder expectedPositionString = new StringBuilder("BMW : ");

        // When
        Position position = Position.createPosition(car);

        // Then
        assertThat(position).isNotNull();
        assertThat(position.distanceValue()).isEqualTo(0);
        assertThat(position.positionValue()).isEqualTo(expectedPositionString.toString());
    }

    @Test
    @DisplayName("전진할 경우 direction이랑 position이 달라지는지")
    public void move() {
        // given
        Position position = Position.createPosition(car);
        StringBuilder expectedPositionString = new StringBuilder("BMW : -");
        // when
        position.move(5);
        //then
        assertThat(position.distanceValue()).isEqualTo(1);
        assertThat(position.positionValue()).isEqualTo(expectedPositionString.toString());
    }
}