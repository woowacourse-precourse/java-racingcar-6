package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;
import racingcar.utils.Validator;


public class InputViewTest {

    private Validator validator = new Validator();
    @Test
    void 이름입력값에_자동차가_한대밖에_없을때() {
        String input = "car1";
        assertThatThrownBy(() -> validator.checkCarValidate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차가 한 대 밖에 없습니다.");
    }

    @Test
    void 이름입력이_비어있을때() {
        String input="car1,,car3";
        assertThatThrownBy(() -> validator.checkCarValidate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 비어 있습니다.");
    }

    @Test
    void 이름이_5자_초과일때() {
        String input = "car1,car2,caaaaaar";
        assertThatThrownBy(() -> validator.checkCarValidate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 동일한_이름이_존재할때() {
        String input = "car1,car2,car3,car1";
        assertThatThrownBy(() -> validator.checkCarValidate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("동일한 이름이 존재합니다.");
    }

    @Test
    void 반복횟수_입력이_숫자가_아닐때() {
        String input = "I'mStirng";
        assertThatThrownBy(() -> validator.checkRaceValidate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상의 숫자를 입력해 주세요.");
    }

    @Test
    void 반복횟수_입력이_비어있을때() {
        String input = "";
        assertThatThrownBy(() -> validator.checkRaceValidate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상의 숫자를 입력해 주세요.");
    }

}
