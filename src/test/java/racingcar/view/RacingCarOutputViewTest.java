package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.dto.CarDto;
import racingcar.dto.RacingResultDto;
import racingcar.dto.RacingRoundResultDto;

public class RacingCarOutputViewTest {
    private static final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();

    private static CarDto setCarInfo(String carName, int position) {
        return new CarDto(carName, position);
    }

    @BeforeEach
    void setup() {
        OUTPUT.reset();
        System.setOut(new PrintStream(OUTPUT));
    }

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
    void printEachRacingResult(RacingRoundResultDto racingRoundResultDto, String expectedMessage) {
        RacingCarOutputView racingCarOutputView = new RacingCarOutputView();
        racingCarOutputView.printEachRacingResult(racingRoundResultDto);
        assertThat(OUTPUT.toString()).isEqualTo(expectedMessage);
    }

    static Stream<Arguments> providePrintEachRacingResultTestArguments() {
        return Stream.of(
                arguments(new RacingRoundResultDto(List.of(setCarInfo("pobi", 1),
                                setCarInfo("woni", 0))),
                        """
                                pobi : -
                                woni :\s
                                                                
                                """),
                arguments(new RacingRoundResultDto(List.of(setCarInfo("pobi", 2),
                                setCarInfo("woni", 4),
                                setCarInfo("jun", 3))),
                        """
                                pobi : --
                                woni : ----
                                jun : ---
                                                                
                                """)
        );
    }

    @DisplayName("최종 우승자를 출력한다.")
    @Test
    void printWinnerTest() {
        RacingCarOutputView racingCarOutputView = new RacingCarOutputView();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("pobi");
        strings.add("woni");
        RacingResultDto racingResultDto = RacingResultDto.from(strings);
        racingCarOutputView.printWinner(racingResultDto);
        assertThat(OUTPUT.toString()).isEqualTo("최종 우승자 : pobi, woni\n");
    }
}
