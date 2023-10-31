package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.RandomNumber;

public class RandomNumberTest extends NsTest {
    private RandomNumber testNumber;
    @BeforeEach
    void setUp() {
        testNumber = RandomNumber.generate();
    }
    @Test
    void 숫자_판단_4이상일때_참() {
        assertRandomNumberInRangeTest(
                () -> {
                    boolean expected = testNumber.isEqualOrGreaterThanFour();
                    assertThat(expected).isTrue();
                },
                4
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
