package racingcar.exception;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.util.ErrorMessage.ERROR_NOT_EMPTY;
import static racingcar.util.ErrorMessage.ERROR_WRONG_CARS_NAME;
import static racingcar.util.ErrorMessage.ERROR_WRONG_CAR_NAME;
import static racingcar.util.ErrorMessage.ERROR_WRONG_NUMBER_OF_RACE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExceptionManagerTest {

    ExceptionManager em = new ExceptionManager();

    @Test
    @DisplayName("입력받은_자동차_이름_입력값이_없을때_예외")
    void test_checkCarsNameException2() {
        assertThatThrownBy(() -> em.checkCarsNameException(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_NOT_EMPTY);
    }

    @Test
    @DisplayName("입력받은_자동차_이름_콤마로_끝날때_예외")
    void test_checkCarsNameException1() {
        assertThatThrownBy(() -> em.checkCarsNameException("blue,red,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_WRONG_CARS_NAME);
    }

    @Test
    @DisplayName("각각의_자동차_이름_입력값이_없을때_예외")
    void test_checkCarNameException1() {
        String[] arrayOfCarName = {"apple", ""};
        assertThatIllegalArgumentException()
                .isThrownBy(() -> em.checkCarNameException(arrayOfCarName))
                .withMessage(ERROR_NOT_EMPTY);
    }

    @Test
    @DisplayName("각각의_자동차_이름_글자수_5이상일때_예외")
    void test_checkCarNameException2() {
        String[] arrayOfCarName = {"apple", "banana"};
        assertThatIllegalArgumentException()
                .isThrownBy(() -> em.checkCarNameException(arrayOfCarName))
                .withMessage(ERROR_WRONG_CAR_NAME);
    }

    @Test
    @DisplayName("자동차_이동횟수_입력값이_없을때_예외")
    void test_checkNumberOfRace1() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> em.checkNumberOfRace(""))
                .withMessage(ERROR_NOT_EMPTY);
    }

    @Test
    @DisplayName("자동차_이동횟수_입력값이_0일때_예외")
    void test_checkNumberOfRace2() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> em.checkNumberOfRace("0"))
                .withMessage(ERROR_WRONG_NUMBER_OF_RACE);
    }

    @Test
    @DisplayName("자동차_이동횟수_입력값이_숫자가_아닐때_예외")
    void test_checkNumberOfRace3() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> em.checkNumberOfRace("@"))
                .withMessage(ERROR_WRONG_NUMBER_OF_RACE);
    }


}