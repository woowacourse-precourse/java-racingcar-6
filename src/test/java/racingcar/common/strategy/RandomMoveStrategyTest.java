package racingcar.common.strategy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.common.generator.RandomGenerator;

class RandomMoveStrategyTest {
    @Test
    public void 이동_가능() {
        // given: 람다식으로 테스트용 RandomGenerator 생성
        RandomGenerator testRandomGenerator = () -> 5;

        MoveStrategy strategy = RandomMoveStrategy.of(testRandomGenerator);

        // when: isMovable 메서드 호출
        boolean isMovable = strategy.isMovable();

        // then: 결과 검증
        Assertions.assertTrue(isMovable);
    }

    @Test
    public void 이동_불가능() {
        // given: 람다식으로 테스트용 RandomGenerator 생성
        RandomGenerator testRandomGenerator = () -> 3;

        MoveStrategy strategy = RandomMoveStrategy.of(testRandomGenerator);

        // when: isMovable 메서드 호출
        boolean isMovable = strategy.isMovable();

        // then: 결과 검증
        Assertions.assertFalse(isMovable);
    }
}
