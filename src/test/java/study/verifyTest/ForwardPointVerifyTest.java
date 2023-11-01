package study.verifyTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.service.RandomNumberPickService;
import racingcar.verify.ForwardPointVerify;

public class ForwardPointVerifyTest {

    @Test
    void verifyTest() {
        RandomNumberPickService randomNumberPickService = new RandomNumberPickService();
        randomNumberPickService.pick();

        ForwardPointVerify forwardPointVerify = new ForwardPointVerify(randomNumberPickService);
        if (randomNumberPickService.getRandomNumber() >= 4 && randomNumberPickService.getRandomNumber() <= 9) {
            Assertions.assertThat(forwardPointVerify.verify()).isEqualTo(true);
        } else if (randomNumberPickService.getRandomNumber() < 4) {
            Assertions.assertThat(forwardPointVerify.verify()).isEqualTo(false);
        }

    }
}
