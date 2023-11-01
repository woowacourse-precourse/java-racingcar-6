package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static testutil.TestUtil.createCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameTest {

    @Test
    @DisplayName("5글자를 초과하지 않은 이름은 예외를 발생시키지 않는다.")
    void should_NotThrowIllegalArgumentException_When_LengthIsLessThanOrEqualTo5() {
        Car car = createCar("몽키D루피", 0);
        assertThat(car.getName()).isEqualTo("몽키D루피");
    }

    @Test
    @DisplayName("5글자를 초과한 이름은 예외를 발생시킨다.")
    void should_ThrowIllegalArgumentException_When_LengthIsGreaterThan5() {
        assertThrows(IllegalArgumentException.class, () -> {
            createCar("롤로노아조로", 0);
        });
    }
}
