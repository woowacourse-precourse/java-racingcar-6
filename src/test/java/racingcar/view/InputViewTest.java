package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest extends NsTest {

    @Test
    public void 입력_테스트() {
        String input = "pobi,crong,honux";
        run(input, "1");
    }

    @Test
    public void 이름_입력_5자_초과_테스트() {
        // given
        String input = "pobi,crong,honux,java,python";

        try {
            // when
            run(input, "1");
        } catch (IllegalArgumentException e) {

            // then
            assertThat(e.getMessage()).isEqualTo("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    @Test
    public void 시도_횟수_음수_테스트() {
        // given
        String input = "pobi,crong,honux";
        String tryCount = "-1";

        try {
            // when
            run(input, tryCount);
        } catch (IllegalArgumentException e) {
            // then
            assertThat(e.getMessage()).isEqualTo("시도 횟수는 1 이상만 가능합니다.");
        }
    }

    @Test
    public void 시도_횟수_0회_테스트() {
        // given
        String input = "pobi,crong,honux";
        String tryCount = "0";

        try {
            // when
            run(input, tryCount);
        } catch (IllegalArgumentException e) {
            // then
            assertThat(e.getMessage()).isEqualTo("시도 횟수는 1 이상만 가능합니다.");
        }
    }

    @Test
    public void 시도_횟수_숫자가_아닌경우() {
        // given
        String input = "pobi,crong,honux";
        String tryCount = "a";

        try {
            // when
            run(input, tryCount);
        } catch (IllegalArgumentException e) {
            // then
            assertThat(e.getMessage()).isEqualTo("시도 횟수는 숫자만 가능합니다.");
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}