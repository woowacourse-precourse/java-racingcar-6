package racingcar.game;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class MoveOpportunityTest {

    @Test
    public void MoveOpportunity_객체_생성_시_moveOpportunity가_0_이상으로_생성할_수_있다() throws Exception {
        // given
        int moveCount = 0;

        // when
        //then
        assertThatCode(() -> {
            MoveOpportunity moveOpportunity = new MoveOpportunity(moveCount);
        }).doesNotThrowAnyException();
    }

    @Test
    public void MoveOpportunity_객체_생성_시_moveOpportunity가_0_미만이면_예외를_발생시킨다() throws Exception {
        // given
        int moveCount = -1;

        // when
        //then
        assertThatThrownBy(() -> {
            MoveOpportunity moveOpportunity = new MoveOpportunity(moveCount);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void move_메서드_호출_시_moveOpporotunity가_0_이하면_예외를_발생시킨다() throws Exception {
        // given
        int moveCount = 0;
        MoveOpportunity moveOpportunity = new MoveOpportunity(moveCount);

        // when
        //then
        assertThatThrownBy(() -> {
            MoveOpportunity move = moveOpportunity.move();
        }).isInstanceOf(IllegalArgumentException.class);
    }

}