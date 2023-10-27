package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.service.Generate;

public class GenerateTest {

    @Test
    void generate_랜덤값_확인(){
        Generate generate = new Generate();
        int randomNum = generate.RandomNumber();

        assertThat(randomNum).isBetween(0,9);
    }

}
