package racingcar.output;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarDto;
import racingcar.domain.Winner;

class OutputManagerTest {
    private OutputManager outputManager;
    private final PrintStream out = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    public void init() {
        outputManager = new OutputManager();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void after() {
        System.setOut(out);
    }

    @Test
    @DisplayName("게임 시작 문구 출력")
    void 게임시작_문구_출력() {
        outputManager.printStartGame();
        assertThat(outputStreamCaptor.toString().trim())
                .isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    @DisplayName("게임 시행 결과 출력")
    void 게임시행_결과_출력() {
        List<CarDto> carDtos = List.of(
                new CarDto("hyeongil", 1),
                new CarDto("hyeongil2", 2),
                new CarDto("hyeongil3", 3)
        );
        outputManager.printResultOfTrial(carDtos);
        assertThat(outputStreamCaptor.toString().trim())
                .isEqualTo("hyeongil : -\nhyeongil2 : --\nhyeongil3 : ---");

    }

    @Test
    @DisplayName("최종 우승자가 1명이면, 쉼표 구분 없이 단독 출력")
    void 최종1명_우승자_출력() {
        List<Winner> winners = List.of(new Winner("hyeongil"));
        outputManager.printGameResult(winners);

        assertThat(outputStreamCaptor.toString().trim())
                .isEqualTo("최종 우승자 : hyeongil");
    }

    @Test
    @DisplayName("최종 우승자가 다수이면, 쉼표 구분으로 모든 명단 출력")
    void 최종n명_우승자_출력() {
        List<Winner> winners = List.of(
                new Winner("hyeongil"),
                new Winner("hyeongil2"),
                new Winner("hyeongil3")
        );
        outputManager.printGameResult(winners);
        assertThat(outputStreamCaptor.toString().trim())
                .isEqualTo("최종 우승자 : hyeongil, hyeongil2, hyeongil3");
    }
}