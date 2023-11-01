package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RacingTest {
    private static final int MOVING_FORWARD = 4;
    private static final Integer STOP = 3;
    private Racing racing;
    private List<Car> carList;

    @BeforeEach
    void setUp() {
        racing = new Racing();

        Car car1 = new Car("robin");
        Car car2 = new Car("hood");
        Car car3 = new Car("kyle");

        carList = new ArrayList<>(List.of(car1, car2, car3));
    }


    @Test
    @DisplayName("String으로 받은 carName으로 Car의 객체를 만들어 리스트에 추가확인 테스트")
    void 자동차_객체_리스트_추가_테스트() {
        List<String> carNameList = new ArrayList<>(List.of("robin", "hood", "kyle"));
        List<Car> carList = racing.toCarList(carNameList);

        for (int i = 0; i < carList.size(); i++) {
            assertThat(carList.get(i).getName()).isEqualTo(carNameList.get(i));
        }
    }

    @ParameterizedTest
    @MethodSource("stringIntAndBooleanProvider")
    void 전진_가능_여부_확인_테스트(int randomNum, boolean result) throws NoSuchMethodException  {
        Method method = racing.getClass().getDeclaredMethod("isMove", Car.class);
        method.setAccessible(true);

        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("hil");
                    car.initRandomNum();
                    assertEquals((boolean)method.invoke(racing, car), result);

                },
                randomNum
        );
    }

    static Stream<Arguments> stringIntAndBooleanProvider() {
        return Stream.of(
                arguments(STOP, false),
                arguments(MOVING_FORWARD, true)
        );
    }

    @Test
    void 자동차_객체_전진_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < 3; i++) {
                        racing.initCarsRandomNum(carList);
                        racing.modifyForwardNum(carList);
                    }
                    assertThat(carList.get(0).getForwardNum()).isEqualTo(1);
                    assertThat(carList.get(1).getForwardNum()).isEqualTo(3);
                    assertThat(carList.get(2).getForwardNum()).isEqualTo(1);
                },
                STOP, MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 전진_횟수_최대값_테스트() throws NoSuchMethodException {
        Method method = racing.getClass().getDeclaredMethod("findMaxValue", List.class);
        method.setAccessible(true);

        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < 3; i++) {
                        racing.initCarsRandomNum(carList);
                        racing.modifyForwardNum(carList);
                    }
                    int result = (int)method.invoke(racing, carList);
                    assertEquals(result, 3);
                },
                STOP, MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );

    }

    @Test
    @DisplayName("우승자가 여러명 일때 확인 테스트")
    void 우승자_찾기_복수_테스트() {

        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < 3; i++) {
                        racing.initCarsRandomNum(carList);
                        racing.modifyForwardNum(carList);
                    }

                    assertThat(racing.findWinners(carList)).containsExactly("hood", "kyle");
                },
                STOP, MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                STOP, STOP, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("우승자가 한 명일 때 확인하는 테스트")
    void 단독_우승자_찾기_테스트() {

        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < 3; i++) {
                        racing.initCarsRandomNum(carList);
                        racing.modifyForwardNum(carList);
                    }

                    assertThat(racing.findWinners(carList)).containsExactly("hood");
                },
                STOP, MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

}