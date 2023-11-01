package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.view.IOTest;

class RacingCarControllerTest extends IOTest {

    @DisplayName("사용자가 조건에 맞는 문자열을 입력하면 해당 문자열을 그대로 반환")
    @ParameterizedTest
    @CsvSource({"'abc,edd', 'abc,edd'", "'pobi,woni,jun', 'pobi,woni,jun'"})
    void askCarNames(String input, String expected) {
        //given
        allocateSystemIn(input);
        RacingCarController racingCarController = new RacingCarController();

        //when
        String inputString = racingCarController.askCarNames();

        //then
        assertThat(inputString).isEqualTo(expected);
    }

    @DisplayName("사용자가 조건에 맞도록 반복 횟수를 입력 받으면 숫자로 변경하여 반환")
    @ParameterizedTest
    @CsvSource({"1, 1", "12, 12", "01, 1"})
    void askRepeatCount(String input, Integer expected) {
        //given
        allocateSystemIn(input);
        RacingCarController racingCarController = new RacingCarController();

        //when
        Integer repeatCount = racingCarController.askRepeatCount();

        //then
        assertThat(repeatCount).isEqualTo(expected);
    }
}