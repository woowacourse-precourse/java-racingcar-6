package util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.NumberFactory;

@DisplayName("NumberFactory 테스트")
public class NumberFactoryTest {
    private final int testCase = 100000;
    @Test
    @DisplayName("생성한 임의의 값은 0이상 9이하이다.")
    public void getRandomNumberTest() {
        // when - then
        for(int i = 0; i < testCase; i++) {
            int randomNumber = NumberFactory.getRandomNumber();
            Assertions.assertThat(randomNumber).isBetween(0, 9);
        }
    }
}
