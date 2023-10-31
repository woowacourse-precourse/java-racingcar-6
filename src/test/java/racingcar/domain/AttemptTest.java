package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class AttemptTest {
    private Attempt attempt;
    private InputStream inputCount;

    @BeforeEach
    void setUp() {
        attempt = new Attempt();
        inputCount = System.in;
    }

    @Test
    @DisplayName("시도할 수를 정상적으로 반환")
    void testSuccessGetCount() {
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int expected = 2;
        int result = attempt.getCount();

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("숫자가 아닌 형식을 입력")
    void testGetCountWithNotInt() {
        String count= "two";

        assertThatThrownBy(() -> attempt.checkInt(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 형식이 아닙니다. 숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("숫자가 아닌 형식을 입력")
    void testGetCountWithNotNatural() {
        int count= -1;

        assertThatThrownBy(() -> attempt.checkNatural(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1이상의 수를 입력해주세요.");
    }
}