package study.serviceTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.service.RandomNumberPickService;

public class RandomNumberPickServiceTest {

    @Test
    void pickTest() {
        RandomNumberPickService randomNumberPickService = new RandomNumberPickService();
        randomNumberPickService.pick();
        Assertions.assertThat(
                (randomNumberPickService.getRandomNumber() >= 0)
                        && (randomNumberPickService.getRandomNumber() <= 9))
                .isEqualTo(true);
    }

    @Test
    void getRandomNumberTest() {
        RandomNumberPickService randomNumberPickService = new RandomNumberPickService();
        Assertions.assertThat(randomNumberPickService.getRandomNumber()).isEqualTo(-1);
    }
}
