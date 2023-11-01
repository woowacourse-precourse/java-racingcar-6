package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.IOTest;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


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
    void inputRacingCountNormalTest(String playerInput, int expectedRacingCount){
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
                Arguments.of("34",34),
                Arguments.of(" 34 ",34),
                Arguments.of("  09 ",9)
        );
    }

//    @DisplayName("플레이어 경주 횟수 입력 정상 테스트")
//    @Test
//    void inputRacingCountNormalTest(){
//        //given
//        final InputView inputView = new InputView();
//        systemIn("34");
//
//        //when
//        Integer racingCount = inputView.inputRacingCount();
//
//        //then
//        assertThat(racingCount).isEqualTo(34);
//
//    }

//
//    @DisplayName("플레이어 경주 횟수 입력 공백포함 정상 테스트")
//    @Test
//    void inputRacingCountIncludedSpaceNormalTest(){
//        //given
//        final InputView inputView = new InputView();
//        systemIn("    34    ");
//
//        //when
//        Integer racingCount = inputView.inputRacingCount();
//
//        //then
//        assertThat(racingCount).isEqualTo(34);
//
//    }
//    @DisplayName("플레이어 경주 횟수 입력 첫자리수 0 정상 테스트")
//    @Test
//    void inputRacingCountStart0NormalTest(){
//        //given
//        final InputView inputView = new InputView();
//        systemIn("034");
//
//        //when
//        Integer racingCount = inputView.inputRacingCount();
//
//        //then
//        assertThat(racingCount).isEqualTo(34);
//
//    }
//
//    @ValueSource(strings = { "ㅇㄹㅇㄹ", "3 4","-3","0"})
//
//    @DisplayName("플레이어 경주 횟수 문자열 입력 에러 테스트")
//    @Test
//    void inputRacingCountNotNumberErrorTest(){
//        //given
//        final InputView inputView = new InputView();
//        systemIn("dfdf");
//
//        //when, then
//        assertThatIllegalArgumentException().isThrownBy(() -> {inputView.inputRacingCount();});
//
//    }
//
//    @DisplayName("플레이어 경주 횟수 음수 입력 에러 테스트")
//    @Test
//    void inputRacingCountNotPositiveNumberErrorTest(){
//        //given
//        final InputView inputView = new InputView();
//        systemIn("-3");
//
//        //when, then
//        assertThatIllegalArgumentException().isThrownBy(() -> {inputView.inputRacingCount();});
//
//    }
//
//    @DisplayName("플레이어 경주 횟수 0 입력 에러 테스트")
//    @Test
//    void inputRacingCount0ErrorTest(){
//        //given
//        final InputView inputView = new InputView();
//        systemIn("0");
//
//        //when, then
//        assertThatIllegalArgumentException().isThrownBy(() -> {inputView.inputRacingCount();});
//
//    }
//
//
//    @DisplayName("플레이어 경주 횟수 숫자사이 공백 입력 에러 테스트")
//    @Test
//    void inputRacingCountNumberBetweenSpaceErrorTest(){
//        //given
//        final InputView inputView = new InputView();
//        systemIn("0 9 5");
//
//        //when, then
//        assertThatIllegalArgumentException().isThrownBy(() -> {inputView.inputRacingCount();});
//
//    }


}
