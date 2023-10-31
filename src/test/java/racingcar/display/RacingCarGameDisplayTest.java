package racingcar.display;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarGameDisplayTest {
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("자동차 이름 입력 문구를 출력한다.")
    void printGameStartMessage() {
        // given
        String message = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

        // when
        Consumer<String> c = nm -> RacingCarGameDisplay.printGameStartMessage();
        c.accept(message);

        // then
        assertThat(message).isEqualTo(outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("시도할 횟수 문구를 출력한다.")
    void printGameCountMessage() {
        // given
        String message = "시도할 회수는 몇회인가요?";

        // when
        Consumer<String> c = nm -> RacingCarGameDisplay.printGameCountMessage();
        c.accept(message);

        // then
        assertThat(message).isEqualTo(outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("실행 결과를 출력한다.")
    void printGameResultMessage() {
        // given
        String message = "실행 결과";

        // when
        Consumer<String> c = nm -> RacingCarGameDisplay.printGameResultMessage();
        c.accept(message);

        // then
        assertThat(message).isEqualTo(outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("자동차 이동 결과를 자동차 이름 순으로 출력한다.")
    void printCarMovementResultMessage() {
        // given
        String message = "jang : --\n"
                + "pobi : -";
        Map<String, String> carMovementMap = Map.of(
                "pobi", "-",
                "jang", "--"
        );

        // when
        Consumer<String> c = nm -> RacingCarGameDisplay.printCarMovementResultMessage(carMovementMap);
        c.accept(message);

        // then
        assertThat(message).isEqualTo(outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("최종 우승자를 출력한다.")
    void printFinalWinnerNames() {
        // given
        String message = "최종 우승자 : jang, pobi";
        List<String> finalWinnerNames = List.of("pobi", "jang");

        // when
        Consumer<String> c = nm -> RacingCarGameDisplay.printFinalWinnerNames(finalWinnerNames);
        c.accept(message);

        // then
        assertThat(message).isEqualTo(outputStreamCaptor.toString().trim());
    }
}