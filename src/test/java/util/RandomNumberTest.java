package util;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class RandomNumberTest {
    private static MockedStatic<RandomNumber> randoms;

    @BeforeAll
    public static void beforeClass() {
        randoms = mockStatic(RandomNumber.class);
    }

    @AfterAll
    public static void afterAll() {
        randoms.close();
    }

    @Test
    public void 범위_안에_값인지_확인() {
        for (int i = 0; i < 10000; i++) {
            int randomNumber = RandomNumber.generateRandomNumber();
            assertTrue(randomNumber >= 0 && randomNumber <= 9);
        }
    }
}
