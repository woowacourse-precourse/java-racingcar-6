package racingcar.Model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.Model.RandomModel.checkRandomNumber;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class RandomModelTest extends NsTest {

    @Test
    void random_0부터3까지는False() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThat(checkRandomNumber()).isFalse();
                },
                0
        );
    }

    @Test
    void random_4부터9까지는True() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThat(checkRandomNumber()).isTrue();
                },
                4
        );
    }

    @Override
    public void runMain() {
        checkRandomNumber();
    }
}
