package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.numbergenerators.NumberGenerator;
import racingcar.utils.numbergenerators.TestNumberGenerator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    private Car movableCar;
    private Car nonmovableCar;

    @BeforeEach
    void setUp() {
        //이동가능한 자동차
        NumberGenerator movableNumberGenerator = new TestNumberGenerator(4);
        movableCar = new Car("CarName", movableNumberGenerator);
        //이동 불가능한 자동차
        NumberGenerator nonmovableNumberGenerator = new TestNumberGenerator(1);
        nonmovableCar = new Car("CarName", nonmovableNumberGenerator);
    }

    @Test
    @DisplayName("이동불가_기준넘지않음")
    void nonmovableCarShouldNotMove() {
        nonmovableCar.move();

        assertThat(nonmovableCar.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("이동가능_기준이상")
    void movableCarShouldMove() {
        movableCar.move();

        assertThat(movableCar.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("최대거리True반환")
    void returnTrueForMaximunDistance() {
        movableCar.move();

        assertThat(movableCar.isMaxDistance(1)).isTrue();
        assertThat(movableCar.isMaxDistance(0)).isFalse();
    }
}