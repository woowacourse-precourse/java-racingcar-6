package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.model.Cars;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

class RacingCarGameServiceTest {

    RacingCarGameService racingCarGameService = new RacingCarGameService();

    @DisplayName("4이상수_전진")
    @Test
    void isMoveFoward(){
        //given
        Car car = new Car("pobi",0);
        List<Car> inputCars = Arrays.asList(car);
        Cars cars = new Cars(inputCars);

        assertRandomNumberInRangeTest(
                () -> {
                    //when
                    racingCarGameService.fowardCars(cars);

                    //then
                    assertThat(cars.getCars().get(0).getStep()).isEqualTo(1);
                },
                4
        );
    }

    @DisplayName("4이하수_미전진")
    @Test
    void isNotFoward(){
        //given
        Car car = new Car("pobi",0);
        List<Car> inputCars = Arrays.asList(car);
        Cars cars = new Cars(inputCars);

        assertRandomNumberInRangeTest(
                () -> {
                    //when
                    racingCarGameService.fowardCars(cars);

                    //then
                    assertThat(cars.getCars().get(0).getStep()).isEqualTo(0);
                },
                3
        );
    }

    @DisplayName("최대_전진거리_정상반환")
    @Test
    void isCorrectMaxStep(){
        //given
        Car car1 = new Car("pobi",2);
        Car car2 = new Car("woni",3);
        Car car3 = new Car("jun",4);
        List<Car> inputCars = Arrays.asList(car1, car2, car3);
        Cars cars = new Cars(inputCars);

        //when
        int maxStepValue = racingCarGameService.getMaxStep(cars);

        //then
        Assertions.assertThat(maxStepValue).isEqualTo(4);
    }

    @DisplayName("정상범위_랜덤수출력")
    @Test
    void isCorrectRangeRandomNumber(){

        for(int i=0;i<1000;++i){
            //when
            int value = racingCarGameService.generateRandomNumber();

            //then
            if(value<0 || value>9) fail();
        }
    }
}