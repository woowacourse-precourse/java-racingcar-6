package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.RaceService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }


    @Test
    public void testCreateCars() {
        // Given
        String[] carNames = {"pobi", "woni"};

        // When
        RaceService raceService = new RaceService();
        List<Car> cars = raceService.createCars(carNames);

        // Then
        assertThat(cars).hasSize(2);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
    }

    @Test
    public void testPrintWinners() {
        // Given
        RaceService raceService = new RaceService();
        List<Car> cars = raceService.createCars(new String[]{"pobi", "woni"});
        cars.get(0).move();
        cars.get(1).move();

        // When
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        raceService.printWinners(cars);
        String output = outputStream.toString();

        // Then
        assertThat(output).contains("최종 우승자 : pobi, woni");
    }
}
