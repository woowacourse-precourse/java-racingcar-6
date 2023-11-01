package racingcar.Domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void _0에서_9사이에_있는_무작위_값을_생성한다(){

        String input = "apple";
        Car car = new Car(input, 0);
        Integer result = car.createRandomValue();

        assertThat(result).isGreaterThanOrEqualTo(0);
        assertThat(result).isLessThan(10);

    }


    @Test
    void 무작위_값이_4이상이라면_전진한다(){

        String input = "apple";
        Car car = new Car(input, 0);
        Integer randomValue = car.createRandomValue();

        if(car.checkRandomValueValidation(randomValue)) {

            car.moveCar(randomValue);
            assertThat(car.getPoint()).isEqualTo(randomValue);
        }

    }

    @Test
    void 무작위_값이_4미만이라면_정지한다(){

        String input = "apple";
        Car car = new Car(input, 0);
        Integer randomValue = car.createRandomValue();

        if(!car.checkRandomValueValidation(randomValue)) {
            assertThat(car.getPoint()).isEqualTo(0);
        }

    }



}


