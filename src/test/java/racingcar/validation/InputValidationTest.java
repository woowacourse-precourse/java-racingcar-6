package racingcar.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidationTest {

    @Test
    @DisplayName("플레이어의 입력값이 공백일 때 예외처리 테스트")
    public void blankException(){
        Assertions.assertThrows(IllegalArgumentException.class , () -> {
            new InputValidation("");
        });
    }

    @Test
    @DisplayName("플레이어의 입력값의 길이가 6이상일 때 예외처리 테스트")
    public void lengthException(){
        Assertions.assertThrows(IllegalArgumentException.class , () -> {
            new InputValidation("length6");
        });
    }
}