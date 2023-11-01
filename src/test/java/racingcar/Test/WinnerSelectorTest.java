package racingcar.Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.winner.WinnerSelector;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerSelectorTest {

    @Test
    @DisplayName("가장 많이 움직인 차량의 이름들을 반환한다.")
    void 가장_많이_움직인_차량의_이름들을_반환() {
        String[] names = {"car1", "car2", "car3", "car4"};
        int[] countsByName = {3, 4, 3, 4};
        int maxCount = 4;

        List<String> winners = WinnerSelector.getWinners(maxCount, names, countsByName);

        assertThat(winners).containsExactly("car2", "car4");
    }

    @Test
    @DisplayName("모든 차량이 같은 거리만큼 움직였을 때, 모든 차량이 우승자로 반환한다.")
    void 모든_차량이_같은_거리만큼_움직였을_때_모든_차량이_우승자로_반환() {
        String[] names = {"car1", "car2", "car3"};
        int[] countsByName = {3, 3, 3};
        int maxCount = 3;

        List<String> winners = WinnerSelector.getWinners(maxCount, names, countsByName);

        assertThat(winners).containsExactly("car1", "car2", "car3");
    }
}
