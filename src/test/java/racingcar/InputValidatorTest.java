package racingcar;

import static org.assertj.core.api.Assertions.*;

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
        assertThatThrownBy(()-> {InputValidator.validateName(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름 입력 검증")
    void 중복_이름_에러_테스트() {
        //given
        List<String> input = Arrays.asList("name", "pobi", "name");
        //when
        assertThatThrownBy(()-> {InputValidator.validateName(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수 입력 검증")
    void 공백_입력_테스트() {
        //given
        String input = "";
        //when,then
        assertThatThrownBy(()-> {InputValidator.validateTryNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열_입력_테스트() {
        //given
        String input = "한번";
        //when,then
        assertThatThrownBy(()-> {InputValidator.validateTryNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 소수_입력_테스트(){
        //given
        String input ="3.7";
        //when,then
        assertThatThrownBy(()-> {InputValidator.validateTryNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }


}