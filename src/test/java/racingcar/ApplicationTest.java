package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.ListAssert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    Inputs inputs = new Inputs();

    @Test
    void 자동차_이름들을_쉼표로_분리() {
        //자동차 이름이 1개인 경우
        String carName = "자동차1";
        //자동차 이름이 여러개인 경우
        String carNames = "자동차1,자동차2,자동차3";
        //자동차 이름이 5글자를 넘는 경우
        String tooLongCarName = "자동차이름5글자이상";
        //자동차 이름이 5글자를 넘고 쉼표로 구분된 경우
        String tooLongCarNames = "자동차이름5글자이상,자동차1";
        //콤마 이후에 공백이 있는 경우
        String carNameWithSpace = "자동차1, 자동차2";

        //자동차 이름이 1개인 경우
        inputs.carNamesList.clear();
        inputs.splitCarNames(carName);
        assertThat(inputs.carNamesList).containsExactly(carName);

        //자동차 이름이 여러개인 경우
        inputs.carNamesList.clear();
        inputs.splitCarNames(carNames);
        assertThat(inputs.carNamesList).containsExactly("자동차1", "자동차2", "자동차3");

        //자동차 이름이 5글자를 넘는 경우
        inputs.carNamesList.clear();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputs.splitCarNames(tooLongCarNames))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("비정상적인 값을 입력하셨습니다. 경주를 자동으로 종료합니다."));

        //자동차 이름이 5글자를 넘고 쉼표로 구분된 경우
        inputs.carNamesList.clear();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputs.splitCarNames(tooLongCarNames))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("비정상적인 값을 입력하셨습니다. 경주를 자동으로 종료합니다."));

        //콤마 이후에 공백이 있는 경우
        inputs.carNamesList.clear();
        inputs.splitCarNames(carNameWithSpace);
        assertThat(inputs.carNamesList).containsExactly("자동차1", " 자동차2");
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

        @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
