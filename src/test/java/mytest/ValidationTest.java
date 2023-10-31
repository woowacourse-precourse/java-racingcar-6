package mytest;

import static org.assertj.core.api.Assertions. *;

import java.util.LinkedHashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validation.ValidationMan;

public class ValidationTest {
    static LinkedHashMap<String, StringBuilder> testMap = null;
    @BeforeAll
    static void init() {
        testMap = new LinkedHashMap<>();
        testMap.put("pobi", new StringBuilder("--"));
        testMap.put("helloo", new StringBuilder("-"));
    }

    @DisplayName("중복된 이름이 없는지 확인")
    @Test
    void checkException1()
    {
        assertThat(ValidationMan.checkException(testMap,1)).isEqualTo(false);
    }
    @DisplayName("이름이 5가 넘는지 확인")
    @Test
    void checkException2()
    {
        assertThat(ValidationMan.checkException(testMap,2)).isEqualTo(false);
    }
    @DisplayName("시도횟수가 숫자인지 아닌지 확인")
    @Test
    void checkExcpetion3()
    {
        assertThat(ValidationMan.checkException("NaN")).isEqualTo(false);
    }
}
