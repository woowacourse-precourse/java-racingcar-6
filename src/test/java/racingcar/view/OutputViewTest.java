package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Judge;
import racingcar.domain.RacingCars;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private OutputView outputView;
    private OutputStream outMessage;
    private Judge judge;

    @BeforeEach
    void setUp() {
        this.outputView = new OutputView();
        this.outMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outMessage));
        this.judge = new Judge();
    }

    @DisplayName("전진 stop 메세지 테스트")
    @Test
    void racingNow() {
        RacingCars racingCars = new RacingCars(List.of("asdf", "qwer"));
        racingCars.getCars().get(0).move(5);

        outputView.racingNow(racingCars);
        assertThat(outMessage.toString())
                .contains("asdf : -")
                .contains("qwer :");

    }

    @DisplayName("단일 우승자 출력 테스트")
    @Test
    void printWinner() {
        RacingCars racingCars = new RacingCars(List.of("asdf", "qwer"));
        racingCars.getCars().get(0).move(5);

        outputView.printWinners(judge.getWinners(racingCars.getCars()));
        assertThat(outMessage.toString())
                .contains("최종 우승자")
                .contains("asdf")
                .doesNotContain("qwer");
    }

    @DisplayName("중복 우승자 출력 테스트")
    @Test
    void printWinners() {
        RacingCars racingCars = new RacingCars(List.of("asdf", "qwer", "zxcv","uiop"));
        racingCars.getCars().get(0).move(5);
        racingCars.getCars().get(1).move(5);
        racingCars.getCars().get(2).move(5);

        outputView.printWinners(judge.getWinners(racingCars.getCars()));
        assertThat(outMessage.toString())
                .contains("최종 우승자")
                .contains("asdf")
                .contains("qwer")
                .contains("zxcv")
                .doesNotContain("uiop");
    }
}