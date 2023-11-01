package racingcar.domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    Car car;

    @BeforeEach
    void init() {
        car = new Car("pobi");
    }

    @Test
    @DisplayName("4이상의 수가 들어올 때 전진 성공")
    void succesMove() {
        // Given
        int isFrontNumber = 4;

        // When
        car.move(isFrontNumber);
        String record = car.makeRecord();

        // Then
        assertThat(record).isEqualTo("pobi : -");
    }

    @Test
    @DisplayName("4미만의 수가 들어올 때 전진 실패")
    void failedMove() {
        // Given
        int isFrontNumber = 3;

        // When
        car.move(isFrontNumber);
        String record = car.makeRecord();

        // Then
        assertThat(record).isEqualTo("pobi : ");
    }
}