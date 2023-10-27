package racingcar.pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constants.InputPattern;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("입력 패턴 중에 ")
class InputPatternTest {

    @Test
    @DisplayName("쉼표(,)로 구분해서 입력하지 않으면 true를 반환한다.")
    void checkCarNamesPattern() {
        //given
        //when
        boolean isNotMatch = InputPattern.isNotMatchCarNamesPattern("pobi/woni,jun");
        //then
        assertThat(isNotMatch).isTrue();

    }

}
