package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.AttempsCount;
import racingcar.model.Name;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

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
    void 경주에_필요한_자동차는_최소_두대_이상() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("경주에 필요한 자동차는 두 대 이상입니다.")
        );
    }

    @Test
    void 자동차의_이름은_영문자_소문자_언더바로_구성() {
        List<String> name = new ArrayList<>();
        name.add("1ab_c"); // 숫자로 시작
        name.add("*ab_c"); // 기호로 시작
        name.add("ab_ c"); // 스페이스 포함

        for (String test : name) {
            assertThatThrownBy(() -> new Name(test))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차의 이름은 영문자(a-z, A-Z)로 시작하고, 영문자와 숫자(0-9)로 구성되어야합니다.");
        }
    }

    @Test
    void 자동차_이름의_길이는_5이하() {
        String test = "abcdef";

        assertThatThrownBy(() -> new Name(test))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름의 길이는 1 이상 5 이하 입니다.");
    }

    @Test
    void 자동차_이름_중복_미허용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("test,test", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차의 이름은 중복될 수 없습니다.")
        );
    }

    @Test
    void 시도횟수는_1번_이상() {
        List<String> count = new ArrayList<>();
        count.add("0");
        count.add("-1");

        for (String test : count) {
            assertThatThrownBy(() -> new AttempsCount(test))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("시도 횟수는 1 이상의 정수입니다.");
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
