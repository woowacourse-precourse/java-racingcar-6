package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.ErrorMessage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ErrorMessageTest {

    @DisplayName("구분자 오류 문구에 대한 테스트")
    @Test
    void delimiterErrorTest() {
        //given
        String delimiterError = "자동차 이름 구분은 ','로 하셔야합니다";

        //then
        assertThat(ErrorMessage.DELIMITER_ERROR.getDelimiterError()).isEqualTo(delimiterError);
    }

    @DisplayName("자동차 이름이 없는 오류 문구에 대한 테스트")
    @Test
    void noCarNamesErrorTest() {
        //given
        String noCarNameError = "레이싱 자동차 이름이 없습니다";

        //then
        assertThat(ErrorMessage.NO_NAME_ERROR.getNoCarsNameError()).isEqualTo(noCarNameError);
    }

    @DisplayName("자동차 이름이 영어로만 이루어있지 않은 오류 문구에 대한 테스트")
    @Test
    void alphaCarNameErrorTest() {
        //given
        String alphaCarNameError = "레이싱 자동차 이름은 영어만 허용됩니다";

        //then
        assertThat(ErrorMessage.ALPHA_NAME_ERROR.getAlphaCarNameError()).isEqualTo(alphaCarNameError);
    }

    @DisplayName("자동차 이름 길이 오류 문구에 대한 테스트")
    @Test
    void carNameLengthErrorTest() {
        //given
        String carNameLengthError = "자동차 이름 길이는 5이하 입니다";

        //then
        assertThat(ErrorMessage.NAME_LENGTH_ERROR.getCarNameLengthError()).isEqualTo(carNameLengthError);
    }

    @DisplayName("중복된 자동차 이름 오류 문구에 대한 테스트")
    @Test
    void duplicatedCarNameErrorTest() {
        //given
        String duplicatedCarNameError = "중복된 자동차 이름이 있습니다";

        //then
        assertThat(ErrorMessage.DUPLICATED_NAME_ERROR.getDuplicatedCarNamesError()).isEqualTo(duplicatedCarNameError);
    }

    @DisplayName("레이스 실행 횟수가 숫자가 아닌 오류 문구에 대한 테스트")
    @Test
    void digitRaceCountErrorTest() {
        //given
        String digitRaceCountError = "숫자만 입력해주시길 바랍니다";

        //then
        assertThat(ErrorMessage.DIGIT_RACE_COUNT_ERROR.getDigitRaceCountError()).isEqualTo(digitRaceCountError);
    }

    @DisplayName("레이스 실행 횟수가 없는 오류 문구에 대한 테스트")
    @Test
    void emptyRaceCountErrorTest() {
        //given
        String emptyRaceCountError = "레이스 횟수를 입력하시길 바랍니다";

        //then
        assertThat(ErrorMessage.EMPTY_RACE_COUNT_ERROR.getEmptyRaceCountError()).isEqualTo(emptyRaceCountError);
    }

    @DisplayName("레이스 시도 횟수가 0일 때 오류 문구에 대한 테스트")
    @Test
    void zeroRaceCountErrorTest() {
        //given
        String zeroRaceCountError = "레이스 시도 횟수는 1 이상입니다";

        //then
        assertThat(ErrorMessage.ZERO_RACE_COUNT_ERROR.getZeroRaceCountError()).isEqualTo(zeroRaceCountError);
    }
}
