package racingcar.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void 이름이_최대_길이를_넘으면_예외() {

        try {
            Method toCarNames = Game.class.getDeclaredMethod("toCarNames", String.class);
            toCarNames.setAccessible(true);

            String[] carNames = (String[]) toCarNames.invoke(Game.class, "abc,defg,hijkl,mnopqr");

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}