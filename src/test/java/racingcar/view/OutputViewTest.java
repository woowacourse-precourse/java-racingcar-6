package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.CarDistanceMessage;
import racingcar.domain.WinnersMessage;

import java.util.List;

class OutputViewTest extends NsTest {

    @Test
    void printCarDistanceMessages_출력_확인() {

        OutputView outputView = new OutputView();
        List<CarDistanceMessage> messages = List.of(new CarDistanceMessage("foo", 1));

        outputView.printCarDistanceMessages(messages);

        Assertions.assertThat(output()).contains("foo : -");

    }

    @Test
    void print_WinnersMessage_출력_확인() {

        OutputView outputView = new OutputView();
        WinnersMessage message = new WinnersMessage(List.of("foo"));

        outputView.printWinnersMessage(message);

        Assertions.assertThat(output()).contains("최종 우승자 : foo");

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}