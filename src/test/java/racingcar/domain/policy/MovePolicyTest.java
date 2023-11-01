package racingcar.domain.policy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.application.RandomMoveRule;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MovePolicyTest {
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("4 이상의 값은 True")
    void 변수가_4_이상의_값은_True(int value) {
        MoveRule moveRule = mock(RandomMoveRule.class);
        when(moveRule.generateValue(MIN_RANGE, MAX_RANGE)).thenReturn(value);

        boolean isMove = MovePolicy.canMove(moveRule);

        assertTrue(isMove);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("4 미만의 값은 False")
    void 변수가_4_미만의_값은_False(int value) {
        MoveRule moveRule = mock(RandomMoveRule.class);
        when(moveRule.generateValue(MIN_RANGE, MAX_RANGE)).thenReturn(value);

        boolean isMove = MovePolicy.canMove(moveRule);

        assertFalse(isMove);
    }
}