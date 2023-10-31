package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.numbergenerators.TestNumberGenerator;

public class CarTest {
    private Car movableCar;
    private Car nonmovableCar;
    private TestNumberGenerator nonmovableNumberGenerator;
    private TestNumberGenerator movableNumberGenerator;

    @BeforeEach
    void setUp() {
        //이동가능한 자동차
        movableNumberGenerator = new TestNumberGenerator(5);
        movableCar = new Car("MoveO");

        //이동 불가능한 자동차
        nonmovableNumberGenerator = new TestNumberGenerator(1);
        nonmovableCar = new Car("MoveX");
    }

    @Test
    @DisplayName("이동불가_기준넘지않음")
    void ShouldNotMoveNonmovableCar() {
        nonmovableCar.move(nonmovableNumberGenerator);

        assertThat(nonmovableCar.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("이동가능_기준이상")
    void ShouldMoveMovableCar() {
        movableCar.move(movableNumberGenerator);

        assertThat(movableCar.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("최대거리_True반환")
    void returnTrueForMaximunDistance() {
        movableCar.move(movableNumberGenerator);

        assertThat(movableCar.isMaxDistance(1)).isTrue();
        assertThat(movableCar.isMaxDistance(0)).isFalse();
    }
}