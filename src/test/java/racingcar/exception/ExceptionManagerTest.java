package racingcar.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.util.ErrorMessage.ERROR_NOT_EMPTY;
import static racingcar.util.ErrorMessage.ERROR_WRONG_CARS_NAME;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExceptionManagerTest {

    ExceptionManager em = new ExceptionManager();

    @Test
    @DisplayName("입력받은_자동차_이름_콤마로_끝날때")
    void test_checkCarsNameException1() {
        assertThatThrownBy(() -> em.checkCarsNameException("blue,red,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_WRONG_CARS_NAME);
    }

    @Test
    @DisplayName("입력받은_자동차_이름_입력값이_없을때")
    void test_checkCarsNameException2() {
        assertThatThrownBy(() -> em.checkCarsNameException(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_NOT_EMPTY);
    }

    @Test
    void checkCarNameException() {
    }

    @Test
    void checkNumberOfRace() {
    }
}