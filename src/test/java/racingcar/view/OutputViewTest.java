package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {
    private OutputView outputView;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
    }

    @Test
    void 우승자_List를_String으로_정상_변환() {
        List<String> winnerList = new ArrayList<>(Arrays.asList("pobi", "woni"));
        String winners = "pobi, woni";

        assertThat(winners).isEqualTo(outputView.convertListToString(winnerList));
    }
}
