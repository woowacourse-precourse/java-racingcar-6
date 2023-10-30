package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class OutputViewTest extends NsTest {

    @Test
    @DisplayName("출력 - 시도할 회수는 몇회인가요?")
    public void testPrintRacingCountInputMessage() {
        //given

        //when
        OutputView.printRacingCountInputMessage();
        String result = output();

        //then
        Assertions.assertThat(result).isEqualTo("시도할 회수는 몇회인가요?");
    }

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

    @Test
    @DisplayName("출력(여러 명일 경우) - 최종 우승자 : 자동차 이름 표시 (,으로 구분)")
    public void testPrintRacingWinnerMany() {
        //given
        List<String> carNames = List.of("CarA", "CarB");

        //when
        OutputView.printRacingWinner(carNames);
        String racingWinnerMessage = output();

        //then
        Assertions.assertThat(racingWinnerMessage).isEqualTo("최종 우승자 : CarA, CarB");
    }

    @Test
    @DisplayName("출력(한 명일 경우) - 최종 우승자 : 자동차 이름 표시 (,으로 구분)")
    public void testPrintRacingWinnerOne() {
        //given
        List<String> carNames = List.of("CarA");

        //when
        OutputView.printRacingWinner(carNames);
        String racingWinnerMessage = output();

        //then
        Assertions.assertThat(racingWinnerMessage).isEqualTo("최종 우승자 : CarA");
    }

    @Override
    protected void runMain() {
    }
}