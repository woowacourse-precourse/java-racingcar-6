package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.constant.TextConstant.ATTEMPT_COUNT_INPUT_MESSAGE;
import static racingcar.constant.TextConstant.RACING_CAR_NAME_INPUT_MESSAGE;

class MessagePrinterTest {

    @Nested
    class CarNameInputMessagePrinterTest extends NsTest {

        @Test
        void 경주할_자동차_이름_입력_요청_메세지_출력() {
            // when
            runMain();

            // then
            assertThat(output()).isEqualTo(RACING_CAR_NAME_INPUT_MESSAGE);
        }

        @Override
        protected void runMain() {
            MessagePrinter messagePrinter = new MessagePrinter();
            messagePrinter.printCarNameInputMessage();
        }
    }

    @Nested
    class AttemptCountInputMessagePrinterTest extends NsTest {

        @Test
        void 시도할_횟수_입력_요청_메세지_출력() {
            // when
            runMain();

            // then
            assertThat(output()).isEqualTo(ATTEMPT_COUNT_INPUT_MESSAGE);
        }

        @Override
        protected void runMain() {
            MessagePrinter messagePrinter = new MessagePrinter();
            messagePrinter.printAttemptCountInputMessage();
        }
    }
}