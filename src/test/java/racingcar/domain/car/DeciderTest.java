package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DeciderTest {
    static class oneGenerator implements Generator {
        @Override
        public int generate(int startInclusive, int endInclusive) {
            return 1;
        }
    }

    @Test
    void 기준보다_작은_수를_뽑으면_isSucceed_메소드가_false를_반환한다() {
        //given
        Rule rule = new DecideRule();
        Generator testGenerator = new oneGenerator();
        Decider decider = Decider.of(rule, testGenerator);

        //when
        boolean result = decider.isSucceed();

        //then
        assertFalse(result);
    }

    static class nineGenerator implements Generator {
        @Override
        public int generate(int startInclusive, int endInclusive) {
            return 9;
        }
    }

    @Test
    void 기준보다_큰_수를_뽑으면_isSucceed_메소드가_true를_반환한다() {
        //given
        Rule rule = new DecideRule();
        Generator testGenerator = new nineGenerator();
        Decider decider = Decider.of(rule, testGenerator);

        //when
        boolean result = decider.isSucceed();

        //then
        assertTrue(result);
    }
}