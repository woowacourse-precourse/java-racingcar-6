package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.IOTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class InputViewTest extends IOTest {


    @DisplayName("플레이어가 자동차 이름 입력 정상 테스트")
    @Test
    void inputCarNameNormalTest() {
        // given
        final InputView inputView = new InputView();
        final String playerInput = "우하하, 우히히, 헤헤";
        systemIn(playerInput);

        // when
        List<String> playerInputName = inputView.inputCarName();

        // then
        assertThat(playerInputName).as("사용자가 입력한 값이 제대로 분리되지 않았습니다.")
                .containsOnly("우하하", "우히히", "헤헤");
    }

    @DisplayName("플레이어 경주 횟수 입력 정상 테스트")
    @ParameterizedTest
    @CsvSource({ "34, 34"," 34 , 34"})
    void inputRacingCountNormalTest(String playerInput, int expectedRacingCount){
        //given
        final InputView inputView = new InputView();
        systemIn(playerInput);

        //when
        Integer racingCount = inputView.inputRacingCount();

        //then
        assertThat(racingCount).isEqualTo(expectedRacingCount);


    }

    @DisplayName("플레이어 경주 횟수 입력 에러 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "ㅇㄹㅇㄹ", "3 4","-3","0"})
    void inputRacingCountErrorTest(String playerInput){
        //given
        final InputView inputView = new InputView();
        systemIn(playerInput);

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {inputView.inputRacingCount();});


    }


}
