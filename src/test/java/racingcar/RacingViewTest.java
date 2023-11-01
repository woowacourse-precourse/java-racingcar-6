package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.OutputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingData;
import racingcar.view.RacingView;

public class RacingViewTest extends BaseTest {

    private final RacingView racingView = RacingView.getInstance();

    @Test
    void testInitIO() {
        setIO("aaa, bbb\n1");
        RacingData result = racingView.initIO();
        assertThat(result.getNames()).containsExactly("aaa", "bbb");
        assertThat(result.getCount()).isEqualTo(1);
    }

    @Test
    void testInitIOError() {
        setIO("aaaaaa, bbb\n1");
        RacingView racingView = RacingView.getInstance();
        assertThatThrownBy(racingView::initIO)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testPrintResult() {
        OutputStream out = setIO();
        racingView.printResult(List.of("aaa", "bbb"));
        assertThat(out.toString()).contains("최종 우승자 : aaa, bbb");
    }
}