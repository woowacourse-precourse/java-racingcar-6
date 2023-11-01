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

class playOutputViewTest {
    private static ByteArrayOutputStream outputMessage;
    private OutputView outputView = new PlayOutputView();

    private MoveRule createMoveRule(int generateNumber) {
        return new MoveRule() {
            @Override
            public int tryMove() {
                return generateNumber;
            }
        };
    }

    private Car createTest(String name, int go) {
        return new Car.CarBuilder(name).setMoveRule(new MoveRule() {
            @Override
            public int tryMove() {
                return go;
            }
        }).build();
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
    @DisplayName("출력이 정상적으로 이루어져야한다.")
    void RacingOutputViewTest() {
        //given
        Car car1 = createTest("tobi", 0);
        Car car2 = createTest("woni", 2);
        Car car3 = createTest("jun", 3);

        car2.move();
        car3.move();

        Map<String, Object> model = new HashMap<>();
        //when
        model.put("cars", new Cars(List.of(car1, car2, car3)));
        outputView.display(model);
        //then
        assertThat(outputMessage.toString()).contains("tobi :");
        assertThat(outputMessage.toString()).contains("woni : --");
        assertThat(outputMessage.toString()).contains("jun : ---");
    }
}