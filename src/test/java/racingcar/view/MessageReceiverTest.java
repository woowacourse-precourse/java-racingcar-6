package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class MessageReceiverTest {

    @Nested
    class CarNamesReceiverTest extends NsTest {

        private String[] carNames;

        @Test
        void 경주할_자동차_이름_입력() {
            // when
            run("pobi,woni,jun");

            // then
            assertThat(carNames.length).isEqualTo(3);
        }

        @Test
        void 경주할_자동차_이름_입력시_5글자가_넘으면_예외발생() {
            // expected
            assertThatThrownBy(() -> run("pobi,wonijun"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Override
        protected void runMain() {
            MessageReceiver messageReceiver = new MessageReceiver();
            carNames = messageReceiver.receiveCarNames();
        }
    }
}