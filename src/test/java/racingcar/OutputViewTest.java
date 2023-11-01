package racingcar;

import java.awt.image.Kernel;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Message;
import racingcar.view.OutputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("결과 출력 테스트")
class OutputViewTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @DisplayName("자동차 하나 이동 시 결과 정상적으로 출력하는지")
    @Test
    void print_result_1() {
        // given
        String carName = "woni";
        String carResult = "-----";

        // when
        OutputView outputView = new OutputView();
        outputView.printCarResult(carName, carResult);

        // then
        assertThat(outputStream.toString()).isEqualTo("woni : -----\r\n");
    }

    @DisplayName("우승자 한 명일 때 결과 정상적으로 출력하는지")
    @Test
    void print_winner_list1() {
        // given
        List<String> winnerList = List.of("pobi");

        // when
        OutputView outputView = new OutputView();
        outputView.printWinnerList(winnerList);

        // then
        assertThat(outputStream.toString()).isEqualTo("최종 우승자 : pobi\r\n");
    }

    @DisplayName("공동 우승자일 때 결과 정상적으로 출력하는지")
    @Test
    void print_winner_list2() {
        // given
        List<String> winnerList = List.of("pobi", "jun");

        // when
        OutputView outputView = new OutputView();
        outputView.printWinnerList(winnerList);

        // then
        assertThat(outputStream.toString()).isEqualTo("최종 우승자 : pobi, jun\r\n");
    }

}
