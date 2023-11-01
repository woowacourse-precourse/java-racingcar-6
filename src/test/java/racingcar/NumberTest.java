package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest{
    @DisplayName("랜덤값이 올바른 범위안에 존재하는지 테스트")
    @Test
    public void generateRandomNumberShouldReturnNumberInRange() {
        Number number = new Number();
        int randomNumber = number.generateRandomNumber();
        assertThat(randomNumber).isBetween(0, 9);
    }
}
