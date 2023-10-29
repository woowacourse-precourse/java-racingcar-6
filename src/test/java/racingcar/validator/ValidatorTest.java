package racingcar.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void 이름이_1에서_5자로_유효할_경우() {
        String[] carNameArr = {"david","pobi","lucy"};
        assertThatCode(()->Validator.inputCarNames(carNameArr))
                .doesNotThrowAnyException();
    }

    @Test
    void 이름이_1에서_5자가_아닐_경우() {
        String[] carNameArr = {"david","pobi","hwanyeong"};
        assertThatThrownBy(()->Validator.inputCarNames(carNameArr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 1~5자만 가능합니다.");
    }

    @Test
    void 중복된_이름이_있는_경우() {
        String[] carNameArr = {"pobi","pobi","hwan"};
        assertThatThrownBy(()->Validator.inputCarNames(carNameArr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 이름이 있습니다.");
    }

    @Test
    void 이름에_공백이_존재할_경우() {
        String[] carNameArr = {"lucy","po bi","hwan"," "};
        assertThatThrownBy(()->Validator.inputCarNames(carNameArr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름에 공백이 존재합니다.");
    }

    @Test
    void 입력받은_횟수가_정수가_아닐_경우() {
        assertThatThrownBy(() -> Validator.isInteger("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 정수만 입력 가능합니다.");
    }

    @Test
    void 입력받은_횟수가_정수인_경우() {
        assertThatCode(() -> Validator.isInteger("3"))
                .doesNotThrowAnyException();
    }
}