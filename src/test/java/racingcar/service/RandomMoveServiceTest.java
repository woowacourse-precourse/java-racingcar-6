package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.service.generator.RandomGenerator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomMoveServiceTest {

    @Test
    void createMovementFlags_랜덤한_수가_전부_0면_전부_False () {
        RandomGenerator fakeGenerator = ()->0;
        RandomMoveService strategy = new RandomMoveService(fakeGenerator);
        List<Boolean> movementFlags = strategy.createMovementFlags(5);
        assertTrue(movementFlags.stream().noneMatch(Boolean::booleanValue));
    }

    @Test
    void createMovementFlags_랜덤한_수가_전부_4면_전부_Ture () {
        RandomGenerator fakeGenerator = ()->4;
        RandomMoveService strategy = new RandomMoveService(fakeGenerator);
        List<Boolean> movementFlags = strategy.createMovementFlags(5);
        assertTrue(movementFlags.stream().allMatch(Boolean::booleanValue));
    }

    @Test
    void createMovementFlags_랜덤한_수가_전부_9면_전부_True () {
        RandomGenerator fakeGenerator = ()->9;
        RandomMoveService strategy = new RandomMoveService(fakeGenerator);
        List<Boolean> movementFlags=strategy.createMovementFlags(5);
        assertTrue(movementFlags.stream().allMatch(Boolean::booleanValue));
    }
}