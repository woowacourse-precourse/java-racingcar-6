package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.dto.CarDto;

class OutputViewTest {
    private static ByteArrayOutputStream outputStream;

    @BeforeEach
    void beforeEach() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void afterEach() {
        System.setOut(System.out);
    }

    @Test
    void 결과_문구_출력() throws Exception {
        // given
        final OutputView outputView = OutputView.getInstance();

        // when
        outputView.printResultMessage();

        // then
        assertThat(outputStream.toString()).hasToString("실행 결과\n");
    }

    @Test
    void 게임_결과_출력() throws Exception {
        // given
        final OutputView outputView = OutputView.getInstance();
        final List<CarDto> carList = List.of(
                new CarDto("pobi", 1),
                new CarDto("woni", 2));

        // when
        outputView.printRacingResult(carList);

        // then
        assertThat(outputStream.toString()).hasToString("pobi : -\nwoni : --\n\n");
    }

    @Test
    void 게임_공동_우승자_출력() throws Exception {
        // given
        final OutputView outputView = OutputView.getInstance();
        final List<CarDto> carList = List.of(
                new CarDto("pobi", 2),
                new CarDto("woni", 2));

        // when
        outputView.printWinners(carList);

        // then
        assertThat(outputStream.toString()).hasToString("최종 우승자 : pobi, woni\n");
    }

    @Test
    void 게임_단독_우승자_출력() throws Exception {
        // given
        final OutputView outputView = OutputView.getInstance();
        final List<CarDto> carList = List.of(new CarDto("pobi", 2));

        // when
        outputView.printWinners(carList);

        // then
        assertThat(outputStream.toString()).hasToString("최종 우승자 : pobi\n");
    }
}
