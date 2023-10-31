package racingcar.input;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputTest {
    static class 자동차_이름_입력 extends NsTest {

        @Test
        void 자동차_이름_입력_시_문자열_배열_변환() {
            run("pobi,woni,jun");
        }

        @Override
        protected void runMain() {
            List<String> result = Input.inputCarName();
            List<String> answer = List.of("pobi", "woni", "jun");

            assertThat(result).isEqualTo(answer);
        }
    }
}