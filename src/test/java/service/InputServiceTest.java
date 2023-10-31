package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.exception.NotValidInputException;
import racingcar.service.InputService;

import static org.assertj.core.api.Assertions.*;
import static racingcar.exception.GameExceptionMessage.*;

@DisplayName("InputService 테스트")
public class InputServiceTest {
    private InputService inputService;

    @BeforeEach
    public void initTest() {
        this.inputService = new InputService();
    }

    @Nested
    @DisplayName("checkCarNameValidation() 매서드 테스트")
    public class checkCarNameValidationTest {
        private final String blankName = " ";
        private final String errorLengthName = "errorName";
        private final String carName = "car";

        @Test
        @DisplayName("차량 이름으로 공백이 입력되는 경우, 오류를 반환한다.")
        public void throwExceptionByBlank() {
            // when - then
            assertThatThrownBy(() -> inputService.checkCarNameValidation(blankName))
                    .isInstanceOf(NotValidInputException.class)
                    .hasMessage(CAR_NAME_CAN_NOT_BE_BLANK.getMessage());
        }

        @Test
        @DisplayName("차량 이름이 1자 미만, 5자 초과인 경우, 오류를 반환한다.")
        public void throwExceptionByLength() {
            // when - then
            assertThatThrownBy(() -> inputService.checkCarNameValidation(errorLengthName))
                    .isInstanceOf(NotValidInputException.class)
                    .hasMessage(CAR_NAME_LENGTH.getMessage());
        }

        @Test
        @DisplayName("차량 이름 유효성 검사에 성공한다.")
        public void successCheckCarNameValidation() {
            // when - then
            assertThatNoException().isThrownBy(() -> inputService.checkCarNameValidation(carName));
        }
    }

    @Nested
    @DisplayName("checkFrequencyValidation() 메서드 테스트")
    public class checkFrequencyValidationTest {
        private final String blankFrequency = " ";
        private final String notNumberValue = "error";
        private final String frequency = "12";

        @Test
        @DisplayName("입력한 반복 횟수가 공백인 경우, 오류를 반환한다.")
        public void throwExceptionByBlank() {
            // when - then
            assertThatThrownBy(() -> inputService.checkFrequencyValidation(blankFrequency))
                    .isInstanceOf(NotValidInputException.class)
                    .hasMessage(USER_INPUT_CAN_NOT_BE_BLANK.getMessage());
        }

        @Test
        @DisplayName("숫자가 아닌 값을 입력하는 경우, 오류를 반환한다.")
        public void throwExceptionByInvalidInput() {
            // when - then
            assertThatThrownBy(() -> inputService.checkFrequencyValidation(notNumberValue))
                    .isInstanceOf(NotValidInputException.class)
                    .hasMessage(FREQUENCY_ONLY_NUMBER.getMessage());
        }

        @Test
        @DisplayName("반복 횟수 유효성 검사에 성공한다.")
        public void successCheckFrequencyValidation() {
            // when - then
            assertThatNoException().isThrownBy(() -> inputService.checkFrequencyValidation(frequency));
        }
    }
}
