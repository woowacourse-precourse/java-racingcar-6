package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class MoveConditionTest {

    @Test
    @DisplayName("MoveCondition이 MOVE면 true를 반환한다.")
    void isMove() {
        MoveCondition move = MoveCondition.MOVE;
        assertThat(move.isMove()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    @DisplayName("determineMoveCondition에 3이하의 값이 들어가면 STOP을 반환한다.")
    void determineMoveConditionReturnedSTOP(int input) {
        MoveCondition moveCondition = MoveCondition.determineMoveCondition(input);
        assertThat(moveCondition).isEqualTo(MoveCondition.STOP);
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    @DisplayName("determineMoveCondition에 4이상의 값이 들어가면 MOVE을 반환한다.")
    void determineMoveConditionReturnedMOVE(int input) {
        MoveCondition moveCondition = MoveCondition.determineMoveCondition(input);
        assertThat(moveCondition).isEqualTo(MoveCondition.MOVE);
    }
}