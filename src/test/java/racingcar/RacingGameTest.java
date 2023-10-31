package racingcar;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingGameTest {
    @Test
    void 우승자_선별() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RacingGame racingGame = new RacingGame();
        Method method = racingGame.getClass().getDeclaredMethod("findWinners", List.class);
        method.setAccessible(true);

        Car target = new Car("짱구");
        Car comparison = new Car("맹구");
        target.addPosition();

        List<String> results = (List<String>) method.invoke(racingGame, Arrays.asList(target, comparison));

        assertThat(results).isEqualTo(Arrays.asList("짱구"));

        comparison.addPosition();
        results = (List<String>) method.invoke(racingGame, Arrays.asList(target, comparison));
        assertThat(results).isEqualTo(Arrays.asList("짱구", "맹구"));
    }
}
