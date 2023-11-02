package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MovingCountTest {

    @Test
    @DisplayName("MovingCount getter 테스트")
    void MovingCount_getter_테스트() {
        //given
        MovingCount movingCount = new MovingCount(0);
        int expectResult = 0;

        //when
        int currentMovingCount = movingCount.getMovingCount();

        //then
        Assertions.assertThat(currentMovingCount).isEqualTo(expectResult);
    }

    @Test
    @DisplayName("MovingCount객체 increase() 정상 동작 테스트")
    void MovingCount_증가_테스트() {
        //given
        MovingCount movingCount = new MovingCount(0);
        int expectResult = 3;

        //when
        movingCount.increase();
        movingCount.increase();
        movingCount.increase();
        int currentMovingCount = movingCount.getMovingCount();

        //then
        Assertions.assertThat(currentMovingCount).isEqualTo(expectResult);

    }

    @Test
    @DisplayName("서로 다른 MovingCount객체 비교 테스트")
    void 서로_다른_MovingCount_비교_테스트() {
        //given
        MovingCount movingCount1 = new MovingCount(0);
        MovingCount movingCount2 = new MovingCount(0);

        //when
        boolean isEqual = movingCount1.equals(movingCount2);

        //then
        Assertions.assertThat(isEqual).isTrue();
    }
}
