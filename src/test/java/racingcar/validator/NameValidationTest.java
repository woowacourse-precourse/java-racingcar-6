package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class NameValidationTest {
    NameValidation valid = new NameValidation();

    @Test
    void 자동차이름_5글자_이하_영어대소문자가_아니고_쉼표구분이_없을때_예외_발생() {
        List<String> namesList = new ArrayList<>();
        namesList.add("wooooo,maro");
        namesList.add("마로,포비");
        namesList.add("woo teco");

        for (String names : namesList) {
            assertThatThrownBy(() -> valid.validate(names))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("5글자 이하의 영어 대소문자만 가능하고 쉼표 구분이 필요합니다");
        }
    }

    @Test
    void 자동차이름_중복된_글자일때_예외_발생() {
        String names = "star,maro,teco,star";
        assertThatThrownBy(() -> valid.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 자동차 이름은 허용되지 않습니다");
    }

    @Test
    void 입력받은_자동차이름_개수가_2개미만일때_예외_발생() {
        String names = "woo";
        assertThatThrownBy(() -> valid.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최소한 자동차 이름을 2개 이상 입력해야 합니다");
    }

}
