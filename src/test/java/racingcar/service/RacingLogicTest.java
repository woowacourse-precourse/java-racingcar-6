package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RacingLogicTest {

    @Test
    void 숫자가_0에서_9사이_랜덤숫자인지() {
        int randomNumber = RacingLogic.makeRandomNumber();
        assertThat(randomNumber).isBetween(0, 9);
    }

    
}