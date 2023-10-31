package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class DeciderTest {
    private final Rule rule = new DecideRule();

    @Test
    void 기준보다_작은_수를_뽑으면_isSucceed_메소드가_false를_반환한다() {
        //given
        Generator oneGenerator = mock(Generator.class);
        when(oneGenerator.generate(anyInt(), anyInt())).thenReturn(1);
        Decider decider = Decider.of(rule, oneGenerator);

        //when
        boolean result = decider.isSucceed();

        //then
        assertFalse(result);
    }

    @Test
    void 기준보다_큰_수를_뽑으면_isSucceed_메소드가_true를_반환한다() {
        //given
        Rule rule = new DecideRule();
        Generator nineGenerator = mock(Generator.class);
        when(nineGenerator.generate(anyInt(), anyInt())).thenReturn(9);
        Decider decider = Decider.of(rule, nineGenerator);

        //when
        boolean result = decider.isSucceed();

        //then
        assertTrue(result);
    }
}