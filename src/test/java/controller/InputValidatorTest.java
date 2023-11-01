package controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static controller.InputValidator.validateCarNameLength;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class InputValidatorTest {


    @DisplayName("입력한 글자가 5글자 넘었을때 발생하는 예외처리 테스트 코드")
    @Test
    void validateCarNameLengthTest(){
        String[] carNamesOver5 = {"Car1", "Car2","Car3","Car4","Car567890"};
        String[] carNamesless5 ={"Car1", "Car2","Car3","Car4","Car5"};

        assertThrows(IllegalArgumentException.class, () -> {
            validateCarNameLength(carNamesOver5);
        });

        assertDoesNotThrow(() -> {
            validateCarNameLength(carNamesless5);
        });
    }
}
