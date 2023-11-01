package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.service.RandomNumber;

public class RandomNumberTest {

    @Test
    void generate_랜덤값_확인(){
        RandomNumber randomNumber = new RandomNumber();
        int randomNum = randomNumber.generate();

        assertThat(randomNum).isBetween(0,9);
    }

}
