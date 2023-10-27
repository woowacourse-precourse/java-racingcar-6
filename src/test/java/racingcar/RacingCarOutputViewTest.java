package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RacingCarOutputViewTest {
    private static final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        OUTPUT.reset();
        System.setOut(new PrintStream(OUTPUT));
    }

    /**
     * - printStartMessage(): 실행 결과를 출력한다. - [ ] `"실행 결과"` 출력.
     * <p>
     * - printEachRacingResult(): `사용자가 입력한 횟수`만큼 각 차수별 실행 결과를 출력한다. - [ ] 경주할 자동차의 이름 순서에 맞게 `이름 : -` 형태로 출력. - [ ]
     * 줄바꿈을 한다.
     * <p>
     * - printWinner(): 최종 우승자를 출력한다. - [ ] 우승자가 2명 이상일 경우 `,`를 구분한다. - [ ] `"최종 우승자 : pobi, jun"` 형태로 출력한다.
     */

    @DisplayName("실행 결과 문자열을 출력한다.")
    @Test
    void printStartMessage() {
        RacingCarOutputView racingCarOutputView = new RacingCarOutputView();
        racingCarOutputView.printStartMessage();
        assertThat(OUTPUT.toString()).isEqualTo("실행 결과\n");
    }

    @DisplayName("매 회차마다 자동차 경주의 결과를 출력한다.")
    @ParameterizedTest
    @MethodSource("providePrintEachRacingResultTestArguments")
    void printEachRacingResult(Cars cars, String expectedMessage) {
        RacingCarOutputView racingCarOutputView = new RacingCarOutputView();
        racingCarOutputView.printEachRacingResult(cars);
        assertThat(OUTPUT.toString()).isEqualTo(expectedMessage);
    }

    static Stream<Arguments> providePrintEachRacingResultTestArguments() {
        return Stream.of(
                arguments(new Cars(List.of(setCar("pobi", true, 1),
                                setCar("woni", false, 0))),
                        """
                                pobi : -
                                woni :\s
                                """),
                arguments(new Cars(List.of(setCar("pobi", true, 2),
                                setCar("woni", false, 4),
                                setCar("jun", true, 3))),
                        """
                                pobi : --
                                woni : ----
                                jun : ---
                                """)
        );
    }

    private static Car setCar(String carName, boolean engineCanMove, int position) {
        return new Car(carName, new FixedCarEngine(engineCanMove), new Position(position));
    }
}
