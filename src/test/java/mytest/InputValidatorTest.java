package mytest;

import org.junit.jupiter.api.Test;
import service.InputValidator;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {
    @Test
    void 자동차이름_5글자이상_예외테스트() {
        //given
        String carListInput = "a,bbbbbb,c";

        //when,then
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.carListValidate(carListInput);
        });
    }

    @Test
    void 자동차이름_미입력_예외테스트() {
        //given
        String carListInput = "";

        //when,then
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.carListValidate(carListInput);
        });
    }

    @Test
    void 자동차_콤마시작_예외테스트() {
        //given
        String carListInput = ",a,b,c";

        //when,then
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.carListValidate(carListInput);
        });
    }


    @Test
    void 자동차이름_공백포함_예외테스트() {
        //given
        String carListInput = "a ,b, c";

        //when,then
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.carListValidate(carListInput);
        });
    }

    @Test
    void 실행횟수_미입력_예외테스트() {
        //given
        String tryCountInput = "";

        //when,then
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.roundInputSetAndValidate(tryCountInput);
        });
    }

    @Test
    void 실행횟수_숫자가아닌입력_예외테스트() {
        //given
        String tryCountInput = "a";

        //when,then
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.roundInputSetAndValidate(tryCountInput);
        });
    }

    @Test
    void 실행횟수_공백포함_예외테스트() {
        //given
        String tryCountInput = "3 ";

        //when,then
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.roundInputSetAndValidate(tryCountInput);
        });
    }
}
