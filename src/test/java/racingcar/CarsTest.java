package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.ExceptionMessage.CAR_NAME_DUPLICATE_EXCEPTION;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

public class CarsTest {

    @Test
    void 정상_자동차_리스트_생성_테스트() {
        // given & when
        Cars cars = Cars.from("pobi,12a,현준");

        // then
        assertThat(cars.isCarsCountEqualTo(3)).isTrue();
    }

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
