package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Winners;


import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.validator.Validator.*;

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
    void 자동차_이름_중복_여부() { // 여기 다시
        String[] carNames = new String[]{"pobi", "pobi", "jun"};
        assertThatThrownBy(() -> checkDuplicateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 자동차_이름_입력_길이_여부() {
        String carName = "pobithe";

        assertThatThrownBy(() -> checkInputCarNames(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 숫자_입력() {
        int count = 0;
        assertThatThrownBy(() -> checkInputNumberPositive(count))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 자동차_전진() {
        int number = 4;
        Car car = new Car("pobi");
        car.goOrStop(number);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 공동우승자() {
        String first = "pobi";
        String second = "jun";
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(first));
        cars.add(new Car(second));
        
        Winners winners = new Winners(cars);
        assertThat(winners.getWinnerNames()).contains(first, second);
    }

    @Test
    void 혼자우승() {
        int randomNumber = 6;
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));

        Car car = new Car("jun");
        car.goOrStop(randomNumber);
        cars.add(car);

        Winners winners = new Winners(cars);
        assertThat(winners.getWinnerNames()).contains("jun");
        assertThat(winners.getWinnerNames()).doesNotContain("pobi");
    }


    @Test
    void 전진한_최대값() {
        List<Car> cars = new ArrayList<>();
        Winners winners = new Winners(cars);

        Car pobi = new Car("pobi");
        Car jun = new Car("jun");

        cars.add(pobi);

        jun.goOrStop(4);
        jun.goOrStop(4);
        jun.goOrStop(4);
        cars.add(jun);

        assertThat(winners.getMaxPosition(cars)).isEqualTo(3);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
