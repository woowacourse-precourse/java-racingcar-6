package mytest;

import static org.assertj.core.api.Assertions. *;

import java.util.LinkedHashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcontroller.ValidationCallMan;
import racingmodel.MainModel;
import validation.ValidationMan;

public class ValidationTest {
    @AfterEach
    void forFuture()
    {
        ValidationTemplete.after();
    }

    @Test
    void checkException1()
    {
        ValidationTemplete.setting("pobi,pobi");
        assertThatThrownBy(() -> ValidationCallMan.callexExceptionCheckForCar(new MainModel())).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void checkException2()
    {
        ValidationTemplete.setting("Hellloo");
        assertThatThrownBy(() -> ValidationCallMan.callexExceptionCheckForCar(new MainModel())).isInstanceOf(
                IllegalArgumentException.class);
    }
}
