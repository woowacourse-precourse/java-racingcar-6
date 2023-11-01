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



}


