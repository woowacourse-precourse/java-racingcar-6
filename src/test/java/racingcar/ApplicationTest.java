package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
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

    @Test
    void 자동차_이름_입력받아_객체_리스트_생성() {

        //given
        String carsName = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(carsName.getBytes()));

        //when
        List<Car> cars = Application.getCars();

        //then
        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(2).getName()).isEqualTo("jun");
        for (int i = 0; i < cars.size(); i++) {
            assertThat(cars.get(i).getMove()).isEqualTo(0);
        }
    }

    @Test
    void 입력값이_숫자인지_확인() {
        String input = "12345";
        int num = Application.validNum(input);
        assertThat(num).isEqualTo(12345);
    }

    @Test
    void 입력값이_숫자가_아닌_경우_예외처리() {
        String input1 = ".";
        assertThatThrownBy(() -> Application.validNum(input1))
                .isInstanceOf(IllegalArgumentException.class);

        String input2 = "12?";
        assertThatThrownBy(() -> Application.validNum(input2))
                .isInstanceOf(IllegalArgumentException.class);

        String input3 = "test";
        assertThatThrownBy(() -> Application.validNum(input3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 랜덤_숫자_범위_확인() {
        int num = Application.getRandomNum();
        assertThat(num).isBetween(0, 9);
    }

    @Test
    void 값_비교_후_전진() {
        //given
        Car car = new Car("car");
        int num = 4;

        //when
        Application.forwardOrStop(car, num);

        //then
        assertThat(car.getMove()).isEqualTo(1);
    }

    @Test
    void 값_비교_후_정지() {
        //given
        Car car = new Car("car");
        int num = 3;

        //when
        Application.forwardOrStop(car, num);

        //then
        assertThat(car.getMove()).isEqualTo(0);
    }

    @Test
    void 차수별_레이스_실행_결과_확인() {

        //given
        List<Car> cars = new ArrayList<>();

        Car car1 = getCar(cars, "car1");

        car1.forward();
        car1.forward();

        //when
        Application.showResult(cars);

        //then
        assertThat(output()).isEqualTo("car1 : --");
    }

    private Car getCar(List<Car> cars, String name) {
        Car car = new Car(name);
        cars.add(car);
        return car;
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
