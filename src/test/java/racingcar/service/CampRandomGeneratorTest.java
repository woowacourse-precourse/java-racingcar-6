package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CampRandomGeneratorTest {

    @Test
    void toChar_랜덤한_수가_전부_0면_전부_False () {
        RandomGenerator fakeGenerator = ()->0;
        RandomMoveStrategy strategy = new RandomMoveStrategy(5,fakeGenerator);
        List<Boolean> movementFlags = strategy.createMovementFlags();
        assertTrue(movementFlags.stream().noneMatch(Boolean::booleanValue));
    }

    @Test
    void toChar_랜덤한_수가_전부_4면_전부_Ture () {
        RandomGenerator fakeGenerator = ()->4;
        RandomMoveStrategy strategy = new RandomMoveStrategy(5,fakeGenerator);
        List<Boolean> movementFlags = strategy.createMovementFlags();
        assertTrue(movementFlags.stream().allMatch(Boolean::booleanValue));
    }

    @Test
    void toChar_랜덤한_수가_전부_9면_전부_True () {
        RandomGenerator fakeGenerator = ()->9;
        RandomMoveStrategy strategy = new RandomMoveStrategy(5,fakeGenerator);
        List<Boolean> movementFlags=strategy.createMovementFlags();
        assertTrue(movementFlags.stream().allMatch(Boolean::booleanValue));
    }
}