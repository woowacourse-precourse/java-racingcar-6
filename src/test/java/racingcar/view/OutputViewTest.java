package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarList.CarDto;

class OutputViewTest extends IOTest {

    private final OutputView outputView = new OutputView();

    @DisplayName("실행 결과 메세지 출력 테스트")
    @Test
    void printResult() {
        String racingResult = "실행 결과\n";

        outputView.printResult();
        assertThat(getOutput()).isEqualTo(racingResult);
    }

    @DisplayName("경기 진행 출력")
    @Test
    void printRoundResult() {
        List<CarDto> carDtoList = new ArrayList<>();
        CarDto car1 = new CarDto("a", 1);
        CarDto car2 = new CarDto("b", 1);
        String result = "a : -\nb : -\n\n";

        carDtoList.add(car1);
        carDtoList.add(car2);
        outputView.printRoundResult(carDtoList);
        assertThat(getOutput()).isEqualTo(result);
    }

    @DisplayName("우승자 출력 테스트")
    @Test
    void printWinner() {
        List<String> winners = new ArrayList<>();
        String winnerMessage = "최종 우승자 : aaa, bbb\n";

        winners.add("aaa");
        winners.add("bbb");
        outputView.printWinner(winners);
        assertThat(getOutput()).isEqualTo(winnerMessage);
    }
}