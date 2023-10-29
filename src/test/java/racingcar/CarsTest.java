package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.ExceptionMessage.CAR_NAME_DUPLICATE_EXCEPTION;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

public class CarsTest {

    @Test
    @DisplayName("정상 자동차 리스트 생성 테스트")
    void correctCarListCreateTest() {
        // given & when
        Cars cars = Cars.from("pobi,12a,현준");

        // then
        assertThat(cars.isCarsCountEqualTo(3)).isTrue();
    }

    @Test
    @DisplayName("같은 이름을 가진 자동차가 있으면 안된다")
    void duplicateCarNameExceptionTest() {
        // given & when
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Cars cars = Cars.from("pobi,pobi");
        });

        // then
        assertThat(exception.getMessage()).isEqualTo(CAR_NAME_DUPLICATE_EXCEPTION.toString());
    }
}
