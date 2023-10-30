package racingcar.UtilTest;


import org.junit.jupiter.api.Test;
import racingcar.Util.Winner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinnerTest {

    @Test
    void 레이스_최종_우승자_확인() {
        List<String> carList = Arrays.asList("kim", "in", "young");
        List<Integer> location = Arrays.asList(4, 3, 4);
        List<String> winner = Winner.carList(carList, location);
        List<String> expectedWinner = Arrays.asList("kim", "young"); // 예상한 우승자 리스트

        assertThat(winner).isEqualTo(expectedWinner);
    }
}
