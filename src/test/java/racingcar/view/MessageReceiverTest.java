package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class MessageReceiverTest {

    @Nested
    class CarNamesReceiverTest extends NsTest {

        private List<String> carNames;

        @Test
        void 경주할_자동차_이름_입력() {
            // when
            run("pobi,woni,jun");

            // then
            assertThat(carNames.size()).isEqualTo(3);
        }

        @Test
        void 경주할_자동차_이름_입력시_5글자가_넘으면_예외발생() {
            // expected
            assertThatThrownBy(() -> run("pobi,wonijun"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 경주할_자동차_이름_입력시_중복된_이름이_존재하면_예외발생() {
            // expected
            assertThatThrownBy(() -> run("pobi,pobi,woni"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Override
        protected void runMain() {
            MessageReceiver messageReceiver = new MessageReceiver();
            carNames = messageReceiver.receiveCarNames();
        }
    }

    @Nested
    class AttemptCountReceiverTest extends NsTest {

        private int attemptCount;

        @Test
        void 시도할_횟수_입력() {
            // when
            run("5");

            // then
            assertThat(attemptCount).isEqualTo(5);
        }

        @Test
        void 시도할_횟수_입력이_0이하이면_예외발생() {
            // expected
            assertThatThrownBy(() -> run("0"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Override
        protected void runMain() {
            MessageReceiver messageReceiver = new MessageReceiver();
            attemptCount = messageReceiver.receiveAttemptCount();
        }
    }
}