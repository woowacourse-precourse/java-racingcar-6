package racingcar.View;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Dto.CarDto;

public class OutputViewTest {
    OutputView outputView = new OutputView();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream newOut = new PrintStream(baos);
    @Test
    void 자동차_이름_입력() {
        System.setOut(newOut);
        outputView.printInputRacingCar();
        assertThat(baos.toString()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        System.setOut(System.out);
    }

    @Test
    void 시도_횟수_입력() {
        System.setOut(newOut);
        outputView.printInputRacingCount();
        assertThat(baos.toString()).contains("시도할 회수는 몇회인가요?");
        System.setOut(System.out);
    }

    @Test
    void 게임_시작() {
        System.setOut(newOut);
        outputView.printGameStart();
        assertThat(baos.toString()).contains("\n게임을 시작합니다.");
        System.setOut(System.out);
    }

    @Test
    void 게임_진행() {
        CarDto carDto = new CarDto("pobi", 1);
        List<CarDto> carDtoList = List.of(carDto);
        System.setOut(newOut);
        outputView.printResult(carDtoList);
        assertThat(baos.toString()).contains("pobi : ");
        System.setOut(System.out);
    }

    @Test
    void 게임_우승자() {
        System.setOut(newOut);
        outputView.printGameWinner(List.of("pobi"));
        assertThat(baos.toString()).contains("최종 우승자 : pobi");
        System.setOut(System.out);
    }
}
