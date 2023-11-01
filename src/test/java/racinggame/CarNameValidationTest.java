package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.exception.CarExceptionMessage;
import racingcar.GameDetail;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 자동차 이름에 대한 검증 테스트
 */
public class CarNameValidationTest {

    @Test
    @DisplayName("자동차 이름 입력 성공")
    void car_name_input_success() {
        String carNames = "a" + GameDetail.CAR_SEPARATOR + "b" + GameDetail.CAR_SEPARATOR + "c";
        assertTrue(Application.isValidCarNames(carNames));
    }

    @Test
    @DisplayName("특수문자 섞어서 자동차 이름 입력시 성공")
    void car_name_with_special_characters_input_success() {
        String carNames = "a#" + GameDetail.CAR_SEPARATOR + "b#" + GameDetail.CAR_SEPARATOR + "c#";
        assertTrue(Application.isValidCarNames(carNames));
    }

    @Test
    @DisplayName("0자의 자동차 이름 입력시 예외 발생")
    void zero_size_car_name_input_exception() {
        String carNames = GameDetail.CAR_SEPARATOR + "b" + GameDetail.CAR_SEPARATOR + "c";
        assertThatThrownBy(() -> Application.isValidCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CarExceptionMessage.OVERSIZE_CAR_NAME);
    }

    @Test
    @DisplayName("5자 초과의 자동차 이름 입력시 예외 발생")
    void oversize_car_name_input_exception() {
        String carNames = "abcdef" + GameDetail.CAR_SEPARATOR + "abc";
        assertThatThrownBy(() -> Application.isValidCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CarExceptionMessage.OVERSIZE_CAR_NAME);
    }

    @Test
    @DisplayName("자동차 이름 입력 없을 시 예외 발생")
    void no_car_name_input_exception() {
        String carNames = "";
        assertThatThrownBy(() -> Application.isValidCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CarExceptionMessage.UNDER_MIN_CAR_COUNT);
    }

    @Test
    @DisplayName("특수문자로만 자동차 이름 입력시 예외 발생")
    void only_special_characters_car_name_input_exception() {
        String carNames = "###" + GameDetail.CAR_SEPARATOR + "@@@";
        assertThatThrownBy(() -> Application.isValidCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CarExceptionMessage.ONLY_SPECIAL_CHARACTER_CAR_NAME);
    }

    @Test
    @DisplayName("자동차 이름 하나만 입력시 예외 발생")
    void only_one_car_name_input_exception() {
        String carNames = "abc";
        assertThatThrownBy(() -> Application.isValidCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CarExceptionMessage.UNDER_MIN_CAR_COUNT);
    }

    @Test
    @DisplayName("중복된 자동차 이름 존재시 예외 발생")
    void duplicate_car_name_input_exception() {
        String carNames = "a" + GameDetail.CAR_SEPARATOR + "a" + GameDetail.CAR_SEPARATOR + "b";
        assertThatThrownBy(() -> Application.isValidCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CarExceptionMessage.DUPLICATE_CAR_NAME);
    }

}
