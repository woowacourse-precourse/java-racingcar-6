package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    public void 초기값_설정() {
        inputValidator = new InputValidator();
    }

    @Test
    public void 쉼표_입력_기준이_틀렸을_경우_IllegalArgumentException을_발생시키는_기능() {
        String input = ",ABC,BBB,,";

        Assertions.assertThatThrownBy(() -> {
            inputValidator.insertRacingCars(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("잘못된 입력 형식입니다.");
    }

    @Test
    public void 이름이_5자_초과일_경우_IllegalArgumentException을_발생시키는_기능() {
        String input = "red,green,blue,rainbow";

        Assertions.assertThatThrownBy(() -> {
            inputValidator.insertRacingCars(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("이름이 5자 초과인 자동차가 존재합니다.");
    }

    @Test
    public void 하나의_자연수가_아닐_경우_IllegalArgumentException을_발생시키는_기능() {
        String input = "12,32";

        Assertions.assertThatThrownBy(() -> {
            inputValidator.insertMoveNum(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("하나의 자연수를 입력하십시오.");
    }
}