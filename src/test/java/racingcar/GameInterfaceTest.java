package racingcar;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class GameInterfaceTest {

    @Test
    public void testCarNameValidation() throws NoSuchMethodException {
        String[] validCarNames = {"HMC", "KIA", "FORD"};
        String[] invalidCarNames = {"longname", "longlongname"};

        Method checkCarNameLength = GameInterface.class.getDeclaredMethod("checkCarNameLength", String.class);
        checkCarNameLength.setAccessible(true);

        for (String name : validCarNames) {
            assertDoesNotThrow(() -> checkCarNameLength.invoke(null, name));
        }

        for (String name : invalidCarNames) {
            assertThrows(InvocationTargetException.class, () -> checkCarNameLength.invoke(null, name));
        }
    }
}
