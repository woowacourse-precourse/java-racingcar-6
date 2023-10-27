package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    public void tryMove_return_false_when_0() throws Exception{
        Car car = new Car("name");
        assertRandomNumberInRangeTest(
                ()-> Assertions.assertThat(car.isMove())
                            .isFalse(),
                0
        );
    }

    @Test
    public void tryMove_return_false_when_3() throws Exception{
        Car car = new Car("name");
        assertRandomNumberInRangeTest(
                ()-> Assertions.assertThat(car.isMove())
                            .isFalse(),
                3
        );
    }

    @Test
    public void tryMove_return_true_when_4() throws Exception{
        Car car = new Car("name");
        assertRandomNumberInRangeTest(
                ()-> Assertions.assertThat(car.isMove())
                            .isTrue(),
                4
        );
    }

    @Test
    public void tryMove_return_true_when_9() throws Exception{
        Car car = new Car("name");
        assertRandomNumberInRangeTest(
                ()-> Assertions.assertThat(car.isMove())
                            .isTrue(),
                4
        );
    }

    @Test
    public void toStringTest1() throws Exception{
        assertRandomNumberInRangeTest(
                ()-> Assertions.assertThat(moveCar("car", 3))
                            .isEqualTo("car : ---"),
                5, 4, 6
        );
    }

    @Test
    public void toStringTest2() throws Exception{
        assertRandomNumberInRangeTest(
                ()-> Assertions.assertThat(moveCar("car", 5))
                        .isEqualTo("car : --"),
                1, 2, 3, 4, 5
        );
    }

    @Test
    public void toStringTest3() throws Exception{
        assertRandomNumberInRangeTest(
                ()-> Assertions.assertThat(moveCar("car", 10))
                        .isEqualTo("car : "),
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1
        );
    }

    private String moveCar(String carName, int roundNum){
        Car car = new Car(carName);
        for(int i = 0; i<roundNum; i++){
            car.isMove();
        }
        return car.getRoundResult();
    }
}