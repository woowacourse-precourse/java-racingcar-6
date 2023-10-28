package racingcar.pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constants.InputPattern;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("입력 패턴 중에 ")
class InputPatternTest {

    @Test
    @DisplayName("쉼표(,)로 구분해서 입력하지 않으면 true를 반환한다.")
    void check_car_names_pattern() {
        //given
        //when
        boolean isNotMatch = InputPattern.isNotMatchCarNamesPattern("pobi/woni,jun");
        //then
        assertThat(isNotMatch).isTrue();

    }

    @Test
    @DisplayName("숫자를 입력하지 않으면 true를 반환한다.")
    void check_attempt_count_numeric_pattern(){
        //given
        //when
        boolean isNotMatch = InputPattern.isNotNumeric("pobi#");
        //then
        assertThat(isNotMatch).isTrue();

    }

}
