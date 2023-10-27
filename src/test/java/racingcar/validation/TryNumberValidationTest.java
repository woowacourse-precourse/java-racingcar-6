package racingcar.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryNumberValidationTest {

    @Test
    @DisplayName("시도할 회수의 입력값이 공백일 때 예외처리 테스트")
    public void blankException(){
        Assertions.assertThrows(IllegalArgumentException.class , () -> {
            new TryNumberValidation("");
        });
    }

    @Test
    @DisplayName("시도할 회수의 입력값이 숫자가 아닐 때 예외처리 테스트")
    public void numberException(){
        Assertions.assertThrows(IllegalArgumentException.class , () -> {
            new TryNumberValidation("abcd");
        });
    }

}