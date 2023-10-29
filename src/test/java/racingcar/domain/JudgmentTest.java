package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class JudgmentTest {


    @Test
    void 숫자가_4_이상인_경우_전진_테스트() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Judgment judgment = Judgment.getInstance();

        Method method = judgment.getClass().getDeclaredMethod("canMoveForward", int.class);
        method.setAccessible(true);

        boolean trueResult = (boolean) method.invoke(judgment, 4);
        assertThat(trueResult).isEqualTo(true);


        boolean falseResult = (boolean) method.invoke(judgment, 3);
        assertThat(falseResult).isEqualTo(false);
    }
}