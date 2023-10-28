package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Validator;
import racingcar.view.InputView;

import java.lang.annotation.Documented;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private Validator validator;
    @BeforeEach
    void setUp(){
        validator = new Validator();
    }
    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @DisplayName("입력받은 자동차이름들이 콤마를 기준으로 5자이하가 아니면 IllegalArgumentException 발생시키기")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,javaji", "pobiaa,woni,jun"})
    void isCarNameFromPlayerValidate(String carName) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.isCarNameFromPlayerValidate(carName))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("입력받은 시도할 횟수가 숫자가 아니면 IllegalArgumentException 발생시키기")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1.2"})
    void isNumberFromPlayerValidate(String number){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.isNumberFromPlayerValidate(number))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
