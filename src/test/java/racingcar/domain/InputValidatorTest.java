package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class InputValidatorTest {
    @Test
    void 올바른_이름목록_문자열() {
        String[] testCases = {
                "pobi,jun,yoon,cass,charm",
                "gun,toil,soy",
                "pig,cat,dog,snake,duck"
        };

        for (String test : testCases) {
            assertThatCode(() -> InputValidator.validateNamesInput(test))
                    .doesNotThrowAnyException();
        }
    }

    @Test
    void 다섯_글자가_넘는_이름() {
        // 이름의 글자 수가 5를 넘어가는 경우, IllegalArgumentException 발생
        String testCases[] = {
                "pobi,jun,sungyoon,cass,charm",
                "pobistic",
                "pobi,jun,sandwich"
        };

        for (String test : testCases) {
            assertThatThrownBy(() -> InputValidator.validateNamesInput(test))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 이어지는_쉼표() {
        // 쉼표가 연속으로 나오는 경우, 즉 이름의 길이가 0일 때이다.
        String testCases[] = {
                "pobi,,jun,jigi",
                "pobi,jun,jigi,,yoon,gun,,cass"
        };

        for (String test : testCases) {
            assertThatThrownBy(() -> InputValidator.validateNamesInput(test))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 쉼표_끝위치_테스트() {
        String testCases[] = {
                ",pobi,jun,jigi",
                "pobi,",
                "pobi,jun,woni,"
        };

        for (String test : testCases) {
            assertThatThrownBy(() -> InputValidator.validateNamesInput(test))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 수가_아닌_문자열() {
        String testCases[] = {
                "123b",
                "1b2",
                "q",
                " 123"
        };

        for (String test : testCases) {
            assertThatThrownBy(() -> InputValidator.validateCountInput(test))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}