package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    @DisplayName("자동차 이름 입력 검증")
    void 글자수_5초과_에러_테스트() {
        //given
        List<String> input = Arrays.asList("names", "over", "number");
        //when,then
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateName(input);
        });

    }

    @Test
    @DisplayName("자동차 이름 입력 검증")
    void 중복_이름_에러_테스트() {
        //given
        List<String> input = Arrays.asList("name", "pobi", "name");
        //when
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateName(input);
        });
    }

    @Test
    @DisplayName("시도 횟수 입력 검증")
    void 공백_입력_테스트() {
        //given
        String input = "";
        //when,then
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateTryNumber(input);
        });
    }

    @Test
    void 문자열_입력_테스트() {
        //given
        String input = "한번";
        //when,then
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateTryNumber(input);
        });
    }

    @Test
    void 소수_입력_테스트(){
        //given
        String input ="3.7";
        //when,then
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateTryNumber(input);
        });
    }


}