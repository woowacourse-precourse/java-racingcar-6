package racingcar.utils;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.CarNameIncorrectException;

class InputValidateTest {

    final String inputNull = null;
    final String inputEmpty = "";
    final String inputBlank = "  ";

    @Test
    @DisplayName("자동차 이름 입력 시 빈값, null 입력 시 예외 발생")
    void nullAndEmptyCheckTest() {

        assertAll("null 입력",
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    InputValidate.validateCarNames(inputNull);
                }),
                () -> assertThrows(CarNameIncorrectException.class, () -> {
                    InputValidate.validateCarNames(inputNull);
                })
        );

        assertAll("emtpy 입력",
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    InputValidate.validateCarNames(inputEmpty);
                }),
                () -> assertThrows(CarNameIncorrectException.class, () -> {
                    InputValidate.validateCarNames(inputEmpty);
                })
        );

        assertAll("'  ' 입력",
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    InputValidate.validateCarNames(inputBlank);
                }),
                () -> assertThrows(CarNameIncorrectException.class, () -> {
                    InputValidate.validateCarNames(inputBlank);
                })
        );
    }

    @Test
    @DisplayName("도전 횟수 입력 받기 숫자 타입 체크")
    void tryCountInputAndNumberTypeCheckTest() {
        // 정상의 경우
        assertDoesNotThrow(() -> InputValidate.validateMovingCount("123"));

        assertAll("예외 발생 그룹",
                // 비정상의 경우 예외 발생
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    InputValidate.validateMovingCount(" ");
                }),
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    InputValidate.validateMovingCount("1 3");
                }),
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    InputValidate.validateMovingCount(" a");
                }),
                // 0 이하의 값 입려 시 예외 발생
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    InputValidate.validateMovingCount("0");
                }),
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    InputValidate.validateMovingCount("-1");
                }),
                // Integer Max 값 이상의 경우 예외 발생
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    InputValidate.validateMovingCount("2147483648");
                })
        );
    }

}