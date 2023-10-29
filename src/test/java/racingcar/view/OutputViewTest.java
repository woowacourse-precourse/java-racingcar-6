package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OutputViewTest extends NsTest {

    @Test
    public void testPrintRacingRoundResult() {
        //given
        String carName = "CarA";
        int position = 3;

        //when
        OutputView.printRacingRoundResult(carName, position);
        String roundResultMessage = output();

        //then
        Assertions.assertThat(roundResultMessage).isEqualTo("CarA : ---");
    }

    @Override
    protected void runMain() {
    }
}