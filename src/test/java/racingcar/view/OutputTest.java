package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

class OutputTest {

    private OutputView outputView;
    private List<Car> cars;
    ByteArrayOutputStream outContent;

    private static final int CAR_NAME_LIMIT = 5;

    @BeforeEach
    void setup() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        outputView = new OutputView();
        Car car1 = new Car("pobi", CAR_NAME_LIMIT);
        Car car2 = new Car("woni", CAR_NAME_LIMIT);
        car1.moveForward();
        cars = List.of(car1, car2);
    }

    @Test
    void 게임_시작() {
        outputView.askGameRuntime();
        assertThat(outContent.toString()).contains("시도할 회수는 몇회인가요?");
    }

    @Test
    void 차_이름_묻기() {
        String delimiter = ",";
        outputView.askCarName(delimiter);
        assertThat(outContent.toString()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void 차_상태_출력() {
        outputView.showCarStatus(cars);
        assertThat(outContent.toString()).contains("pobi : -", "woni : ");
    }

    @Test
    void 우승자_출력() {
        outputView.showWinners(cars);
        assertThat(outContent.toString()).contains("최종 우승자", "pobi, woni");
    }

    @Test
    void 차_이름_출력() {
        outputView.showWinners(cars);
        assertThat(outContent.toString()).contains("pobi, woni");
    }

}
