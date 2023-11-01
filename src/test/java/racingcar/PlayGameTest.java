package racingcar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.lang.reflect.Method;
import java.util.List;

public class PlayGameTest {

    @Test
    public void testGenerateCarList() throws Exception {
        PlayGame playGame = new PlayGame(new String[]{"pobi", "woni"}, 0);
        Method method = PlayGame.class.getDeclaredMethod("generateCarList", String[].class);
        method.setAccessible(true);

        String[] carNames = new String[]{"pobi", "woni"};
        List<Car> cars = (List<Car>) method.invoke(playGame, (Object) carNames);

        assertEquals(2, cars.size());
        assertEquals("pobi", cars.get(0).getName());
        assertEquals("woni", cars.get(1).getName());
    }
}

