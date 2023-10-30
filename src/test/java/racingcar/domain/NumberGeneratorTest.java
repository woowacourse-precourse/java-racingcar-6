package racingcar.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberGeneratorTest extends NsTest {


    @Test
    void 범위의_최솟값인_0보다_작으면_예외() {

        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> runException("pobi,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class),
                -1
        );
    }

    @Test
    void 범위의_최댓값인_9보다_크면_예외() {

        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> runException("pobi,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class),
                10
        );
    }

    @Test
    void 자동차_수만큼_숫자_생성() {
        int numberOfCars = 5;
        final NumberGenerator numberGenerator = new NumberGenerator(numberOfCars);
        
        List<Integer> randomNumbers = numberGenerator.createRandomNumbers();
        
        assertThat(randomNumbers.size()).isEqualTo(numberOfCars);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
