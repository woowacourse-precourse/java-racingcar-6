package racingcar.random;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.NumberGenerator;

public class RandomNumberTest {

    @Test
    void 일부터_구_사이의_랜덤_숫자_얻기() {
        int randomNumber = NumberGenerator.createRandomNumber();

        assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    void 일부터_구_사이의_랜덤_숫자_리스트_얻기() {
        int num = 5;
        List<Integer> randomNumbers = NumberGenerator.createRandomNumber(num);

        assertThat(randomNumbers).hasSize(num);
        assertThat(randomNumbers).allMatch(randomNumber -> (randomNumber >=0 && randomNumber <= 9));
    }
}
