package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.ExceptionMessage.CAR_NAME_DUPLICATE_EXCEPTION;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

public class CarsTest {

    @Test
    void 같은_이름을_가진_자동차가_있으면_안된다() {
        // given & when
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Cars cars = Cars.from("pobi,pobi");
        });
        // then
        assertThat(exception.getMessage()).isEqualTo(CAR_NAME_DUPLICATE_EXCEPTION.toString());
    }
}
