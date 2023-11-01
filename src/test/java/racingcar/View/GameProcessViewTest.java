package racingcar.View;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;

public class GameProcessViewTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        outputStream.reset();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    GameProcessView gameProcessView = new GameProcessView();

    @Test
    @DisplayName("게임 진행 상황 출력 테스트")
    public void 게임_진행_상황_출력_테스트() {
        Car pobiCar = new Car("pobi");
        pobiCar.MoveOneStepForward();
        pobiCar.MoveOneStepForward();

        String carLocationView = gameProcessView.generateLocationView(pobiCar.getLocation());
        assertThat(carLocationView).isEqualTo("--");

        gameProcessView.printCarLocation(pobiCar.getCarName(), pobiCar.getLocation());
        String capturedOutput = outputStream.toString();
        assertThat(capturedOutput).isEqualTo("pobi : --\n");
    }


}

