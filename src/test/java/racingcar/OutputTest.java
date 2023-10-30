package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

public class OutputTest extends NsTest {

    @Test
    public void 테스트_출력결과_테스트() {
        // given
        Car car1 = new Car("pobi");
        car1.moveForward();
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");
        car3.moveForward();

        List<Car> carList = List.of(car1, car2, car3);
        Cars cars = new Cars(carList);
        // when
        OutputView.outputRacingStatus(cars);

        String expectedOutput = "pobi : -\n" +
                "woni : \n" +
                "jun : -";
        // then
        assertEquals(expectedOutput, output());
    }

    @Test
    public void 테스트_단독우승자_출력() {
        // given
        Car car1 = new Car("pobi");
        car1.moveForward();
        car1.moveForward();
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");
        car3.moveForward();

        List<Car> carList = List.of(car1, car2, car3);
        Cars cars = new Cars(carList);
        // when
        OutputView.outputWinnerRacingCarNames(cars);

        String expectedOutput = "최종 우승자 : pobi";
        // then
        assertEquals(expectedOutput, output());
    }

    @Test
    public void 테스트_공동우승자_출력() {
        // given
        Car car1 = new Car("pobi");
        car1.moveForward();
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");
        car3.moveForward();

        List<Car> carList = List.of(car1, car2, car3);
        Cars cars = new Cars(carList);
        // when
        OutputView.outputWinnerRacingCarNames(cars);

        String expectedOutput = "최종 우승자 : pobi, jun";
        // then
        assertEquals(expectedOutput, output());
    }

    @Override
    protected void runMain() {
    }
}
