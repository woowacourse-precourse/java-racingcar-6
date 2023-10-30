package racingcar.view.outputview;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.MoveRule;
import racingcar.service.CarService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class playOutputViewTest {
    private static ByteArrayOutputStream outputMessage;
    private OutputView outputView = new PlayOutputView();
    CarService carService;

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
    @DisplayName("출력이 정상적으로 이루어져야한다.")
    void RacingOutputViewTest() {
        //given
        Car car1 = new Car("tobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");

        car2.move(createMoveRule(2));
        car3.move(createMoveRule(3));

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