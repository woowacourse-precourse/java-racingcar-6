package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 테스트_전체_실행() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "1");
            assertThat(output()).contains("pobi : -", "woni : ", "우승자: pobi");
        }, 4, 3);
    }

    @Test
    void 자동차_이름_예외_테스트() {
        assertThatThrownBy(() -> run("pobi,javaji", "1"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 5글자 이하여야 합니다.");
    }

    @Test
    void 시도_횟수_예외_테스트() {
        assertThatThrownBy(() -> run("pobi,woni", "0"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    void 숫자_입력_예외_테스트() {
        assertThatThrownBy(() -> run("pobi,woni", "not_a_number"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("올바른 숫자를 입력하세요.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
