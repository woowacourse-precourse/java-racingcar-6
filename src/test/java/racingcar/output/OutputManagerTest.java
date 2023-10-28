package racingcar.output;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarDto;

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
}