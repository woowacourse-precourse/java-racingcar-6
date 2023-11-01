package racingcar.games.racing.util;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingFormatterTest {

    @Test
    @DisplayName("자동차 이름들의 정상 입력에 대한 출력 검증")
    public void reformatNormalCarNames() {
        //given
        RacingFormatter formatter = new RacingFormatter();

        //when
        List<String> carNames = formatter.reformatCarNames("poby,고죠,해광");

        //then
        assertThat(carNames.size()).isEqualTo(3);
        assertThat(carNames).containsExactly("poby", "고죠", "해광");
    }

    @Test
    @DisplayName("자동차 이름들 중 5글자가 넘는 입력에 대한 예외 발생 검증")
    public void reformatOverFiveCarNames() {
        RacingFormatter formatter = new RacingFormatter();

        assertThatThrownBy(() -> formatter.reformatCarNames("해광isTheBest,poby"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름들 중 0글자인 입력에 대한 예외 발생 검증")
    public void reformatZeroLetterCarName() {
        RacingFormatter formatter = new RacingFormatter();

        assertThatThrownBy(() -> formatter.reformatCarNames("poby,,해광"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("전진 횟수를 정상적인 숫자로 변환하는 검증")
    void reformatNormalAttemptNumberTest() {
        //given
        RacingFormatter formatter = new RacingFormatter();

        //when
        int result = formatter.reformatAttemptNumber("123");

        //then
        assertThat(result).isEqualTo(123);
    }

    @Test
    @DisplayName("전진 횟수가 0인 문자열 입력에 대한 예회 발생 검증")
    void reformatZeroAttemptNumberTest() {

        RacingFormatter formatter = new RacingFormatter();

        assertThatThrownBy(() -> formatter.reformatAttemptNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("전진 횟수가 0보다 작은 숫자 입력에 대한 예회 발생 검증")
    void reformatNegativeAttemptNumberTest() {
        RacingFormatter formatter = new RacingFormatter();

        assertThatThrownBy(() -> formatter.reformatAttemptNumber("-1"))
               .isInstanceOf(IllegalArgumentException.class);
    }
}