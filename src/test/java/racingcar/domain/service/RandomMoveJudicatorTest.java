package racingcar.domain.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RandomMoveJudicatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"4", "5", "6"})
    void 무작위_값이_4이상일_시_true_반환(int input) {
        assertTrue(new RandomMoveJudge(() -> input).canMove());
    }

}