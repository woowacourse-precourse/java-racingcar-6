package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberTest {
    @Test
    void 랜덤숫자_생성테스트() {
        //랜덤 숫자 생성
        RandomNumber randomNumber = new RandomNumber();

        //랜덤 숫자가 0~9 의 숫자인지 테스트
        assertThat(randomNumber.getRandomNumber()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }

}