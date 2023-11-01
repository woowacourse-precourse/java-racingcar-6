package domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Movable;
import racingcar.domain.RandomNumberGenerator;

public class MovableTest {
    @Test
    @DisplayName("4 이상에서 전진하는지 검증")
    public void 전진_테스트() throws Exception {
        //given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator() {
            @Override
            public int generate() {
                return 4;
            }
        };
        //when
        Movable movable = new Movable(randomNumberGenerator);

        //then
        assertTrue(movable.canMove());
    }

    @Test
    @DisplayName("3 이하에서 정지하는지 검증")
    public void 정지_테스트() throws Exception {
        //given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator() {
            @Override
            public int generate() {
                return 3;
            }
        };
        //when
        Movable movable = new Movable(randomNumberGenerator);

        //then
        assertFalse(movable.canMove());
    }


}
