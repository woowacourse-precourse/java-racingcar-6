package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    private final Validator validator = new Validator();

    @Test
    void String_이름에_대한_빈문자_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkStringCarNames(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void String_이름에_대한_입력오류_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkStringCarNames("pobi,"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    /*
    @Test
    void 이름에_대한_5글자초과_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.ch)
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

     */


}
