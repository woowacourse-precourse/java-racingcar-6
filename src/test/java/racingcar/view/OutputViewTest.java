package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private ByteArrayOutputStream outputStreamCaptor;
    private OutputView outputView;
    private Car car1;
    private Car car2;
    private Car car3;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        car1 = new Car("pobi");
        car2 = new Car("woni");
        car3 = new Car("coni");

        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }


    @Test
    void 우승자_출력_테스트() {
        List<String> winners = new ArrayList<>(List.of("woni, pobi"));

        outputView.printWinner(winners);
        assertThat(getOutput()).isEqualTo("최종 우승자 : woni, pobi");
    }

    @Test
    void 경주_출력_확인_테스트1() {
        car1.increaseForwardNum();
        car1.increaseForwardNum();
        List<Car> carList = new ArrayList<>(List.of(car1, car2, car3));

        assertRandomNumberInRangeTest(
                () -> {
                    outputView.printRacingResult(carList);
                    assertThat(getOutput()).contains("pobi : --", "woni : ", "coni : ");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 경주_출력_확인_테스트2() {
        car2.increaseForwardNum();
        car2.increaseForwardNum();
        List<Car> carList = new ArrayList<>(List.of(car1, car2));

        assertRandomNumberInRangeTest(
                () -> {
                    outputView.printRacingResult(carList);
                    assertThat(getOutput()).contains("pobi : ", "woni : --");
                },
                MOVING_FORWARD, STOP
        );
    }

    String getOutput() {
        return outputStreamCaptor.toString();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
