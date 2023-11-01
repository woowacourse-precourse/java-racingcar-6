package study;

import org.junit.jupiter.api.Test;
import racingcar.UserInputReceiver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserInputTest {

    @Test
    void 입력대로_자동차_이름이_생성되었는지_확인() {

        String input = "pobi,woni,jun";

        assertThat(UserInputReceiver.ReceiveCarNames(input))
                .contains("pobi").contains("woni").contains("jun");
    }

    @Test
    void 자동차_이름_5글자_이상_입력시_예외발생() {

        String input = "pobi,woni,cronggg";

        assertThatThrownBy(() -> UserInputReceiver.ReceiveCarNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 전진횟수_문자열_입력_예외() {

        String input = "뀨";

        assertThatThrownBy(() -> UserInputReceiver.receiveTryTimes(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 전진횟수_음수_또는_0_입력_예외() {
        String input1 = "-1";
        String input2 = "0";

        assertThatThrownBy(() -> UserInputReceiver.receiveTryTimes(input1))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> UserInputReceiver.receiveTryTimes(input2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
