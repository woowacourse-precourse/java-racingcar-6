package racingcar.view.outputview;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.MoveRule;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ResultOutputViewTest {
    private static ByteArrayOutputStream outputMessage;
    private OutputView outputView = new ResultOutputView();

    private MoveRule createMoveRule(int generateNumber) {
        return new MoveRule() {
            @Override
            public int tryMove() {
                return generateNumber;
            }
        };
    }

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out); // 원상복귀
    }

    @Test
    @DisplayName("우승자가 jun 한명만 나와야한다")
    void RacingOutputViewTest() {
        //given
        Car car3 = new Car.CarBuilder("jun").build();

        Map<String, Object> model = new HashMap<>();
        //when
        model.put("winners", new Cars(List.of(car3)));
        outputView.display(model);
        //then
        assertThat(outputMessage.toString()).contains("최종 우승자 : jun");
    }
}