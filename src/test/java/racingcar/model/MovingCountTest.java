package racingcar.model;

import model.MovingCount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MovingCountTest {

    @Test
    @DisplayName("MovingCount getter 테스트")
    public void MovingCount_getter_테스트() {
        //given
        MovingCount movingCount = new MovingCount();
        int expectResult = 0;

        //when
        int currentMovingCount = movingCount.getMovingCount();

        //then
        Assertions.assertThat(currentMovingCount).isEqualTo(expectResult);
    }

    @Test
    @DisplayName("MovingCount객체 increase() 정상 동작 테스트")
    public void MovingCount_증가_테스트() {
        //given
        MovingCount movingCount = new MovingCount();
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
    public void 서로_다른_MovingCount_비교_테스트() {
        //given
        MovingCount movingCount1 = new MovingCount();
        MovingCount movingCount2 = new MovingCount();

        //when
        boolean isEqual = movingCount1.equals(movingCount2);

        //then
        Assertions.assertThat(isEqual).isTrue();
    }
}
