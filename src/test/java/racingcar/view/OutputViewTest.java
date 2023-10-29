package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    @Test
    void printToResult_메서드_사용시_최종_우승자_출력() {
        OutputView outputView = new OutputView();

        String result = outputView.printToResult(List.of("pppp", "angel", "라이언"));

        assertThat(result).isEqualTo("pppp, angel, 라이언");
    }
}