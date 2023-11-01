package racing;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.utils.RacingConfig.MOVED_HISTORY_MARK;
import static racingcar.utils.RacingConfig.NAME_SEPARATOR;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.view.RacingView;

public class RacingViewTest {

    RacingView racingView = new RacingView();

    @Test
    void testFormattedMoveHistories() {
        String name = "pobi";
        int distance = 5;
        String carMoveHistory = MOVED_HISTORY_MARK.repeat(distance);

        String expected = "pobi : -----";
        String actual = racingView.formattedMoveHistories(name, carMoveHistory);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testFormattedWinner() {
        List<String> names = Arrays.asList("pobi","woni");

        String expected = "최종 우승자 : pobi, woni";
        String actual = racingView.formattedWinner(String.join(NAME_SEPARATOR + " ", names));

        assertThat(actual).isEqualTo(expected);
    }
}
