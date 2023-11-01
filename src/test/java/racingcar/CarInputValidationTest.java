package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.utils.ErrorMessage;
import racingcar.validation.CarInputValidation;

public class CarInputValidationTest {

    @Test
    public void testValidate_CarInput_DuplicateNames() {
        CarInputValidation carInputValidation = new CarInputValidation();

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carInputValidation.validateCarInput("pobi,jun,pobi");
        });

        Assertions.assertEquals("중복된 자동차 이름이 존재합니다.", exception.getMessage());
    }

    @Test
    public void testValidate_CarInput_NonDuplicateNames() {
        CarInputValidation carInputValidation = new CarInputValidation();
        carInputValidation.validateCarInput("pobi,jun,crong");
    }

    @Test
    public void testValidate_CarInputNames_With_Spaces() {
        CarInputValidation carInputValidation = new CarInputValidation();

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carInputValidation.validateCarInput("pobi, jun, crong");
        });

        Assertions.assertEquals("자동차 이름에 공백이 포함되어 있습니다.", exception.getMessage());
    }

    @Test
    public void testValidate_CarInput_Valid_NameLength() {
        CarInputValidation carInputValidation = new CarInputValidation();
        carInputValidation.validateCarInput("pobi,jun,crong");
    }

    @Test
    public void testValidate_CarInput_Long_Name_Length() {
        CarInputValidation carInputValidation = new CarInputValidation();

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carInputValidation.validateCarInput(
                    "pobi,jun,longgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");
        });

        Assertions.assertEquals("자동차 이름은 1자에서 5자 사이어야 합니다.", exception.getMessage());
    }

    @Test
    public void testValidate_Car_Input_Fewer_Than_MinCount() {
        CarInputValidation carInputValidation = new CarInputValidation();

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carInputValidation.validateCarInput("pobi");
        });

        Assertions.assertEquals("최소 2대의 자동차 이름을 입력해야 합니다.", exception.getMessage());
    }

    @Test
    public void testValidate_CarInput_Trailing_Comma() {
        CarInputValidation carInputValidation = new CarInputValidation();

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carInputValidation.validateCarInput("pobi,jun,");
        });

        Assertions.assertEquals("마지막 자동차 이름 뒤에 쉼표(,)를 입력하지 마세요.", exception.getMessage());
    }

    @Test
    public void testValidateCarInput_Returns_Same_ErrorMessage_For_Special_Characters() {
        String input = "Car+,Car$2,@Car3,!Car4";
        CarInputValidation carInputValidation = new CarInputValidation();

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> carInputValidation.validateCarInput(input));

        Assertions.assertEquals(ErrorMessage.INVALID_CHARACTERS_ERROR_MESSAGE, exception.getMessage(),
                "특수문자가 있을 경우 동일한 에러 메시지를 반환해야 합니다.");
    }

    @Test
    public void testValidate_CarInput_Allows_Only_English() {
        String input = "차,車";
        CarInputValidation carInputValidation = new CarInputValidation();

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> carInputValidation.validateCarInput(input));

        Assertions.assertEquals(ErrorMessage.INVALID_CHARACTERS_ERROR_MESSAGE, exception.getMessage(),
                "자동차 이름은 영어만 입력해야 합니다.");
    }
}