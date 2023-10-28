package racingcar.game;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class MoveOpportunityTest {

    @Test
    public void MoveOpportunity_객체_생성_시_moveOpportunity가_0_이하면_예외를_발생시킨다() throws Exception {
        // given
        int moveCount = -1;

        // when
        //then
        assertThatThrownBy(() -> {
            new MoveOpportunity(moveCount);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void move_메서드_호출_시_moveOpporotunity가_0_이하면_예외를_발생시킨다() throws Exception {
        // given
        int moveCount = 1;
        MoveOpportunity moveOpportunity = new MoveOpportunity(moveCount);

        // when
        //then
        assertThatThrownBy(() -> {
            MoveOpportunity moveOpportunity0 = moveOpportunity.move();
            moveOpportunity0.move();
        }).isInstanceOf(IllegalStateException.class);
    }

}