package racingcar.ui;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Score;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class UiTest {
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    private static Stream<Arguments> 전진_시도_현황_케이스() {
        return Stream.of(
                Arguments.of(Arrays.asList(new Score("pobi", 1L), new Score("woni", 0L), new Score("jun", 1L)),
                        "pobi : -\n" +
                                "woni : \n" +
                                "jun : -"),
                Arguments.of(Arrays.asList(new Score("pobi", 2L), new Score("woni", 1L), new Score("jun", 2L)),
                        "pobi : --\n" +
                                "woni : -\n" +
                                "jun : --"
                ),
                Arguments.of(Arrays.asList(new Score("pobi", 3L), new Score("woni", 2L), new Score("jun", 3L)),
                        "pobi : ---\n" +
                                "woni : --\n" +
                                "jun : ---"
                ),
                Arguments.of(Arrays.asList(new Score("pobi", 3L), new Score("woni", 3L), new Score("jun", 3L)),
                        "pobi : ---\n" +
                                "woni : ---\n" +
                                "jun : ---"
                ),

                Arguments.of(Arrays.asList(new Score("pobi", 4L), new Score("woni", 3L), new Score("jun", 4L)),
                        "pobi : ----\n" +
                                "woni : ---\n" +
                                "jun : ----"
                )
        );
    }

    private static Stream<Arguments> 우승자를_출력하는_케이스() {
        return Stream.of(
                Arguments.of(Arrays.asList(new Score("pobi", 1L), new Score("jun", 1L)),
                        "최종 우승자 : pobi, jun"),
                Arguments.of(List.of(new Score("pobi", 1L)),
                        "최종 우승자 : pobi")
        );

    }

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void 시작문구를_출력한다() {
        String expectMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        new Ui().start();
        Assertions.assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expectMessage);
    }

    @Test
    void 시도횟수를_묻는_문구를_출력한다() {
        String expectMessage = "시도할 회수는 몇회인가요?";
        new Ui().askPlayCount();
        Assertions.assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expectMessage);
    }

    @Test
    void 전진_시도_가이드_문구를_출력한다() {
        String expectMessage = "실행 결과";
        new Ui().printGameStatusGuide();
        Assertions.assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expectMessage);
    }

    @ParameterizedTest
    @MethodSource("전진_시도_현황_케이스")
    void 전진_시도_현황을_출력한다(List<Score> scores, String expectMessage) {
        new Ui().printGameStatus(scores);
        Assertions.assertThat(outputStreamCaptor.toString().trim()).isEqualToIgnoringNewLines(expectMessage);
    }

    @ParameterizedTest
    @MethodSource("우승자를_출력하는_케이스")
    void 우승자를_출력한다() {
        String expectMessage = "최종 우승자 : pobi, jun";
        new Ui().printGameWinners(Arrays.asList(new Score("pobi", 4L), new Score("jun", 4L)));
        Assertions.assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expectMessage);
    }
}