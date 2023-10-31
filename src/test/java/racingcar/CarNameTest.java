package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.CarPosition;

public class CarNameTest {

    @Test
    @DisplayName("5글자를 초과하지 않은 이름은 예외를 발생시키지 않는다.")
    void should_NotThrowIllegalArgumentException_When_LengthIsLessThanOrEqualTo5() {
        Car car = new Car(new CarName("몽키D루피"), new CarPosition(0));
        assertThat(car.getName()).isEqualTo("몽키D루피");
    }

    @Test
    @DisplayName("5글자를 초과한 이름은 예외를 발생시킨다.")
    void should_ThrowIllegalArgumentException_When_LengthIsGreaterThan5() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car(new CarName("롤로노아조로"), new CarPosition(0));
        });
    }
}
