package tdd.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RandomNumberCheckerTest {
    private boolean randomNumberRangeTest() {
        for (int i = 0; i < 1000000; i++) {
            boolean randomNumber = RandomNumberChecker.generateRandomNumber();
            if (randomNumber) {
                return true;
            }
        } return false;
    }
    @Test
    void 랜덤_숫자_범위가_1에서_9이면_통과() {
        assertThat(randomNumberRangeTest()).isTrue();
    }

}