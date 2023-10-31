package racingcar.carfactory;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.service.GameService;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    void 추출된_숫자가_3일_경우_advanceOnceRandomly() {
        int testNum = 3;
        Car car = new Car("nuri");

        car.advanceOnceRandomly(creatGameServiceForTest(testNum));

        Assertions.assertThat(car.getLocation()).isEqualTo(0);
    }
    @Test
    void 추출된_숫자가_4일_경우_advanceOnceRandomly() {
        int testNum = 4;
        Car car = new Car("nuri");

        car.advanceOnceRandomly(creatGameServiceForTest(testNum));

        Assertions.assertThat(car.getLocation()).isEqualTo(1);
    }
    private GameService creatGameServiceForTest(int testNum){
        GameService gameServiceForTest = new GameService(){
            @Override
            public int randomNumber() {
                return testNum;
            }
        };
        return gameServiceForTest;
    }
}