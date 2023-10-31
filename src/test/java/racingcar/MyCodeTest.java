package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MyCodeTest {
    @Test
    void separateCar_입력문자열을_쉼표로_나누어_배열의_길이가_일치하는지_확인() {
        String input = "car1,car2,car3";
        RCar[] cars = Racing.separateCar(input);
        assertEquals(3, cars.length);
    }
    @Test
    void createRandomNumber_여러번_호출시_랜덤_숫자가_0에서_9_사이인지_확인() {
        RandomNumber randomNumberGenerator = new RandomNumber();

        for (int i = 0; i < 1000; i++) {
            int randomNumber = randomNumberGenerator.createRandomNumber();
            assertTrue(randomNumber >= 0 && randomNumber <= 9);
        }
    }
}
