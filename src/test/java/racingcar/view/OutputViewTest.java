package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.CarDistanceMessage;

import java.util.List;

class OutputViewTest extends NsTest {

    @Test
    void printCarDistanceMessages_출력_확인() {

        OutputView outputView = new OutputView();
        List<CarDistanceMessage> messages = List.of(new CarDistanceMessage("foo", 1));

        outputView.printCarDistanceMessages(messages);

        String log = output();
        Assertions.assertThat(log).contains("foo : -");

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}