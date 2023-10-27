package study;

import org.junit.jupiter.api.Test;
import racingcar.UserInputReceiver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserInputTest {

    @Test
    void 입력대로_자동차_이름이_생성되었는지_확인() {

        String input = "pobi,woni,jun";

        assertThat(UserInputReceiver.receiveCarNameAndGetCarNameList(input))
                .contains("pobi").contains("woni").contains("jun");
    }

    @Test
    void 자동차_이름_5글자_이상_입력시_예외발생() {

        String input = "pobi,woni,cronggg";

        assertThatThrownBy(() -> UserInputReceiver.receiveCarNameAndGetCarNameList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
