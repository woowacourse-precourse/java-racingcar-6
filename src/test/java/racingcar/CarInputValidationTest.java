package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validation.CarInputValidation;

public class CarInputValidationTest {

    @DisplayName("자동차 이름 중복 검증 - 중복된 자동차 이름이 포함된 경우")
    @Test
    public void testValidateCarInputDuplicateNames() {
        CarInputValidation carInputValidation = new CarInputValidation();

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carInputValidation.validateCarInput("pobi,jun,pobi");
        });

        Assertions.assertEquals("중복된 자동차 이름이 존재합니다.", exception.getMessage());
    }

    @DisplayName("자동차 이름 중복 검증 - 중복된 자동차 이름이 포함되지 않은 경우")
    @Test
    public void testValidateCarInputNonDuplicateNames() {
        CarInputValidation carInputValidation = new CarInputValidation();

        // 중복되지 않는 자동차 이름으로 테스트
        carInputValidation.validateCarInput("pobi,jun,crong");

        // 예외가 발생하지 않으면 테스트 통과
    }

    @DisplayName("자동차 이름에 공백이 포함된 경우")
    @Test
    public void testValidateCarInputNamesWithSpaces() {
        CarInputValidation carInputValidation = new CarInputValidation();

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carInputValidation.validateCarInput("pobi, jun, crong");
        });

        Assertions.assertEquals("자동차 이름에 공백이 포함되어 있습니다.", exception.getMessage());
    }

    @DisplayName("자동차 이름 길이 검증 - 유효한 길이인 경우")
    @Test
    public void testValidateCarInputValidNameLength() {
        CarInputValidation carInputValidation = new CarInputValidation();

        // 유효한 이름 길이로 테스트
        carInputValidation.validateCarInput("pobi,jun,crong");

        // 예외가 발생하지 않으면 테스트 통과
    }

    @DisplayName("자동차 이름 길이 검증 - 너무 긴 이름인 경우")
    @Test
    public void testValidateCarInputLongNameLength() {
        CarInputValidation carInputValidation = new CarInputValidation();

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carInputValidation.validateCarInput(
                    "pobi,jun,longgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");
        });

        Assertions.assertEquals("자동차 이름은 1자에서 5자 사이어야 합니다.", exception.getMessage());
    }

    @DisplayName("최소 자동차 대수 검증 - 2대 미만으로 입력한 경우")
    @Test
    public void testValidateCarInputFewerThanMinCount() {
        CarInputValidation carInputValidation = new CarInputValidation();

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carInputValidation.validateCarInput("pobi");
        });

        Assertions.assertEquals("최소 2대의 자동차 이름을 입력해야 합니다.", exception.getMessage());
    }

    @DisplayName("마지막 자동차 이름 뒤에 쉼표를 입력한 경우")
    @Test
    public void testValidateCarInputTrailingComma() {
        CarInputValidation carInputValidation = new CarInputValidation();

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carInputValidation.validateCarInput("pobi,jun,");
        });

        Assertions.assertEquals("마지막 자동차 이름 뒤에 쉼표(,)를 입력하지 마세요.", exception.getMessage());
    }
}
