package util;

import static org.assertj.core.api.Assertions.assertThat;
import static resource.TestData.NINE;
import static resource.TestData.ZERO;

import org.junit.jupiter.api.Test;

public class CarRandomsTest {
    @Test
    void getRandomNumberTest_메서드_리턴값_범위_확인() {
        int randomNumber = CarRandoms.getRandomNumber();
        assertThat(randomNumber).isBetween(ZERO, NINE);
    }
}
