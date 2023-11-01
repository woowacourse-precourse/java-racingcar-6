package racingcar.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputExceptionTest {

    @Test
    public void 중복_이름_테스트() throws Exception {
        //given
        List<String> names = Arrays.asList("car1", "car1", "car3");

        //when & than
        assertThatThrownBy(() -> InputException.validateInputName(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    public void 이름_길이_초과_테스트() throws Exception {
        //given
        List<String> names = Arrays.asList("car1", "car2", "carBenz");

        //when & than
        assertThatThrownBy(() -> InputException.validateInputName(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    public void 시도횟수_숫자_테스트() throws Exception {
        //given
        int moveCount = -1;

        // when & then
        assertThatThrownBy(() -> InputException.validateInputCount(moveCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 이상의 숫자를 입력하세요");
    }
}