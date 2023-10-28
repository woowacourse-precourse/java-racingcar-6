package study;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RandomsTest {

    @Test
    public void pickNumberInRange로_0에서9사이난수생성() {
        int size=1;
        int min = 0;
        int max = 9;
        List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(min, max, size);

        assertThat(randomNumber).hasSize(size);
        assertThat(randomNumber).filteredOn(number-> inRange(min, max, number)).hasSize(size);
    }

    private static boolean inRange(int min, int max, Integer number) {
        return min <= number && number <= max;
    }
}
