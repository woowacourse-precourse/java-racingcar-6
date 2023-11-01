package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.IOTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class InputViewTest extends IOTest {


    @DisplayName("플레이어가 자동차 이름 입력 공백 미포함 테스트")
    @ParameterizedTest
    @ValueSource(strings = "포피,푸피,파피")
    void inputCarNameExcludedSpaceTest(String playerInput) {
        // given
        final InputView inputView = new InputView();
        systemInAndEnd(playerInput);

        // when
        List<String> playerInputName = inputView.inputCarName();

        // then
        assertThat(playerInputName).as("사용자가 입력한 값이 제대로 분리되지 않았습니다.")
                .containsOnly("포피", "푸피", "파피");
    }

    @DisplayName("플레이어가 자동차 이름 입력 공백포함 테스트")
    @ParameterizedTest
    @ValueSource(strings = "   우하하 , 우히히 ,   헤헤   ")
    void inputCarNameIncludedSpaceTest(String playerInput) {
        // given
        final InputView inputView = new InputView();
        systemInAndEnd(playerInput);

        // when
        List<String> playerInputName = inputView.inputCarName();

        // then
        assertThat(playerInputName).as("사용자가 입력한 값이 제대로 분리되지 않았습니다.")
                .containsOnly("우하하", "우히히", "헤헤");
    }


    @DisplayName("플레이어 경주 횟수 입력 정상 테스트")
    @ParameterizedTest
    @MethodSource("provideNormalInputRacingCount")
    void inputRacingCountNormalTest(String playerInput, int expectedRacingCount) {
        //given
        final InputView inputView = new InputView();
        systemInAndEnd(playerInput);

        //when
        Integer racingCount = inputView.inputRacingCount();

        //then
        assertThat(racingCount).isEqualTo(expectedRacingCount);


    }

    private static Stream<Arguments> provideNormalInputRacingCount() {
        return Stream.of(
                Arguments.of("34", 34),
                Arguments.of("    34    ", 34),
                Arguments.of("  09 ", 9)
        );
    }


    @DisplayName("플레이어 경주 횟수 입력 예외 테스트")
    @ParameterizedTest
    @MethodSource("provideExceptionInputRacingCount")
    void inputRacingCountExceptionTest(String playerInput) {
        //given
        final InputView inputView = new InputView();
        systemInAndEnd(playerInput);

        //when then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputView.inputRacingCount();
        });


    }

    private static Stream<Arguments> provideExceptionInputRacingCount() {
        return Stream.of(
                Arguments.of("dfdf"),
                Arguments.of("    3  4    "),
                Arguments.of("0"),
                Arguments.of("-4")
        );
    }

    @DisplayName("경주 횟수 최소횟수 미만 예외 확인테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void checkMinimumRacingCountExceptionTest(int testNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            InputView.checkMinimumRacingCount(testNumber);
        });

    }


}
