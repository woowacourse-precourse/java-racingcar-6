package racingcar.model;

import model.MovingCount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovingCountTest {

    @Test
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
}
