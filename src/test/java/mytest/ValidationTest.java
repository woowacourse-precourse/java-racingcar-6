package mytest;

import static org.assertj.core.api.Assertions. *;

import java.util.LinkedHashMap;
import org.junit.jupiter.api.Test;
import validation.ValidationMan;

public class ValidationTest {

    @Test
    void checkException1()
    {
        LinkedHashMap<String, StringBuilder> testMap = new LinkedHashMap<>();
        testMap.put("pobi",new StringBuilder("-"));
        testMap.put("woni", new StringBuilder("--"));
        assertThatThrownBy(() -> {ValidationMan.getInstance().checkException(testMap,1);}).isInstanceOf(
                IllegalArgumentException.class);
    }
    @Test
    void checkException2()
    {
         assertThatThrownBy(() -> {ValidationMan.getInstance().checkException("Halllo");}).isInstanceOf(
                 IllegalArgumentException.class);
    }
}
