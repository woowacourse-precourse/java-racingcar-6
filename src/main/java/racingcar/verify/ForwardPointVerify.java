package racingcar.verify;

import racingcar.service.RandomNumberPickService;

public class ForwardPointVerify {
    private RandomNumberPickService randomNumberPickService;

    public ForwardPointVerify(RandomNumberPickService randomNumberPickService) {
        this.randomNumberPickService = randomNumberPickService;
    }

    public boolean verify() {
        return randomNumberPickService.getRandomNumber() >= 4;
    }
}
