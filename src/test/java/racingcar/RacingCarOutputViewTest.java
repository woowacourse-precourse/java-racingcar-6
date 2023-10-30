package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.RacingCarOutputView;

public class RacingCarOutputViewTest {

    private static ByteArrayOutputStream outputMessage;
    RacingCarOutputView racingCarOutputView = new RacingCarOutputView();

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("이동 결과에 따라 게임 진행 현황 출력")
    void 이동한_결과에_따라_형식에_맞게_결과를_출력한다() {
        // given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("dayo"));
        cars.add(new Car("dami"));

        assertRandomNumberInRangeTest(() -> {
            // when
            racingCarOutputView.moveResultPrint(2, cars);
            // then
            assertThat(outputMessage.toString()).contains("dayo : --", "dami : -");
        }, 4, 3, 4, 4);
    }

    @Test
    @DisplayName("우승자가 한 명일 때 출력 테스트")
    void 우승자가_한_명일때_단일_출력() {
        List<String> winner = new ArrayList<>();
        winner.add("dami");
        racingCarOutputView.winnerPrint(winner);
        assertThat(outputMessage.toString()).contains("최종 우승자 : dami");
    }

    @Test
    @DisplayName("우승자가 여러 명일 때 출력 테스트")
    void 우승자가_여러_명_일때_콤마로_구분해서_출력() {
        List<String> winners = new ArrayList<>();
        winners.add("dami");
        winners.add("pobi");
        winners.add("dayo");
        racingCarOutputView.winnerPrint(winners);
        assertThat(outputMessage.toString()).contains("최종 우승자 : dami, pobi, dayo");
    }
}
