package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    public void tryMoveTest1() throws Exception{
        assertRandomNumberInRangeTest(
                ()-> Assertions.assertThat(moveCar("car", 3))
                            .isEqualTo("car : ---"),
                5, 4, 6
        );
    }

    @Test
    public void tryMoveTest2() throws Exception{
        assertRandomNumberInRangeTest(
                ()-> Assertions.assertThat(moveCar("car", 5))
                        .isEqualTo("car : --"),
                1, 2, 3, 4, 5
        );
    }

    @Test
    public void tryMoveTest3() throws Exception{
        assertRandomNumberInRangeTest(
                ()-> Assertions.assertThat(moveCar("car", 10))
                        .isEqualTo("car : "),
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1
        );
    }

    private String moveCar(String carName, int roundNum){
        Car car = new Car(carName);
        for(int i = 0; i<roundNum; i++){
            car.tryMove();
        }
        return car.toString();
    }
}