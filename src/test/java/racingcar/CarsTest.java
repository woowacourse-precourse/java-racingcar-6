package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.OutputView;

class CarsTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    public static void main(String[] args) {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");

        Cars cars = new Cars(Arrays.asList(pobi, woni, jun));
        cars.move();
        OutputView.printCarsLocation(cars);
    }

    @Test
    void printCars_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    main(new String[]{});
                    assertThat(output()).contains("pobi : ", "woni : -", "jun : -"); // output() 메서드의 trim() 적용됨을 유의
                },
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        main(new String[]{});
    }
}