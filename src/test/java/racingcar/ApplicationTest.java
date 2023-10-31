package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final String MOVING_MARK = "-";

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

    @ParameterizedTest
    @ValueSource(strings = "pobi, woni, jun")
    @DisplayName("문자열을 입력받아서 배열로 변환시킨다")
    void splitString(String input) {

        String[] result = input.trim().split("\\s*,\\s*");

        assertThat(result).contains("pobi", "woni", "jun");
        assertThat(result).contains("pobi");
    }

    @ParameterizedTest
    @ValueSource(strings = "pobi, woni, jun")
    @DisplayName("리스트를 문자열로 변환시킨다")
    void parseToString(String input) {
        List<String> result = new ArrayList<>();

        String[] strings = input.trim().split("\\s*,\\s*");
        for (int i=0; i<strings.length; i++) {
            result.add(strings[i]);
        }
        String resultString = String.join(", ", result);

        assertEquals(result.get(0), "pobi");
        assertThat(result.get(1)).isEqualTo("woni");
        assertThat(resultString).contains("pobi, woni, jun");
    }

    @Test
    @DisplayName("입력에 따라 Car객체를 생성하고 이름을 부여한다")
    void generateCars() {
        String[] input = {"pobi", "woni", "jun"};
        Cars cars = new Cars();

        for (int i=0; i<input.length; i++) {
            cars.setCars(new Car(input[i]));
        }

        assertThat(cars.getCars().get(0).getName()).isEqualTo("pobi");
        assertThat(cars.getCars().get(2).getName()).isEqualTo("jun");
    }

    @Test
    @DisplayName("자동차를 움직인다")
    void move() {
        Car car = new Car("pobi");
        int[] input = {1, 3, 5, 7, 9};

        for (int i=0; i<input.length; i++)
        if (input[i] >= MOVING_FORWARD) {
            car.getDistance().append("-");
        }

        assertThat(car.getDistance().toString()).isEqualTo("---");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
