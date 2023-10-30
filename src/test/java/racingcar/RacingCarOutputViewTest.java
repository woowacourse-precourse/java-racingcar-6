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

public class RacingCarOutputViewTest {

    private static ByteArrayOutputStream outputMessage;

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
        RacingCarOutputView racingCarOutputView = new RacingCarOutputView();
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
}
