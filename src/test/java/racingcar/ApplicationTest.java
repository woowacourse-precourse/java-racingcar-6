package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void setCars메서드_테스트() {
        String input = "aaa,bbb,ccc,ddd";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<Car> cars = Application.setCars();

        assertThat(cars.size()).isEqualTo(4);

        for (Car car : cars) {
            assertTrue(car.getName().length() <= 5);
        }
    }

    @Test
    void printRoundResult메서드_테스트() {
        List<Car> cars = List.of(new Car("aaa"), new Car("bbb"));
        int roundCount = 2;

        assertRandomNumberInRangeTest(
                () -> {
                    Application.printRoundResult(roundCount, cars);
                    assertThat(output()).contains("aaa : -", "bbb :", "aaa : --");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    void getWinners메서드_테스트() {
        List<Car> cars = List.of(new Car("aaa", 3),
                new Car("bbb", 1),
                new Car("ccc", 3));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Application.printWinners(cars);

        String result = "최종 우승자 : aaa, ccc";
        assertThat(output.toString().trim()).isEqualTo(result);

        System.setOut(System.out);
    }

    @Test
    void printWinners메서드_테스트() {
        List<Car> cars = List.of(new Car("aaa", 4),
                new Car("bbb", 1),
                new Car("ccc", 3),
                new Car("ddd", 4));
        List<String> winners = Application.getWinners(cars);
        assertThat(winners).contains("aaa", "ddd");
    }

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
}
