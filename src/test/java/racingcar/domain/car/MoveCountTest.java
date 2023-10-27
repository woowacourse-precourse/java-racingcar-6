package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class MoveCountTest {

    @DisplayName("입력값이 4 이상이면 하나 증가한다.")
    @ParameterizedTest(name ="{0}를 입력시 count가 1증가한다.")
    @ValueSource(ints = {4,5,6,7,8,9})
    public void move(int controlValue) {
        // given
        MoveCount moveCount = new MoveCount(); //기본 count 값은 0이다.
        // when
        moveCount.controlMovement(controlValue);
        // then
        int result = moveCount.getMoveCount();
        assertThat(result).isOne();
    }

    @DisplayName("입력값이 4 미만이면 증가하지 않는다.")
    @ParameterizedTest(name ="{0}를 입력시 count가 증가하지 않는다.")
    @ValueSource(ints = {0,1,2,3})
    public void stop(int controlValue) {
        // given
        MoveCount moveCount = new MoveCount(); //기본 count 값은 0이다.
        // when
        moveCount.controlMovement(controlValue);
        // then
        int result = moveCount.getMoveCount();
        assertThat(result).isZero();
    }

}