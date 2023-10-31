package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


class IoValidationTest {
    IoValidation ioValidation;

    public IoValidationTest(){
        ioValidation = new IoValidation();
    }

    @Test
    void 차가_두개_보다_적게_입력된_경우(){
        String input = "nuri";

        Assertions.assertThatThrownBy(()->{
                    ioValidation.validateCarNameInput(Arrays.asList(input.split(",")));
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차는 한개 이상이어야 합니다.");
    }

    @Test
    void 차_이름의_길이가_5보다_큰_경우(){
        String input = "nuri,kyojune,shane";

        Assertions.assertThatThrownBy(()->{
            ioValidation.validateCarNameInput(Arrays.asList(input.split(",")));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차의 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 진행할_차수가_올바른지_확인(){
        String input = "454545454545!";
        Assertions.assertThatThrownBy(()->{
            ioValidation.validateTurnNumberInput(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해 주세요.");
    }
}