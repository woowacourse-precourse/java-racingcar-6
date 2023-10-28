package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Assertions;
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

        String expectedOutput =
                "pobi : -\n" +
                "woni : \n" +
                "jun : -";
        // then
        Assertions.assertEquals(expectedOutput, output());
    }

    @Override
    protected void runMain() {
    }
}
