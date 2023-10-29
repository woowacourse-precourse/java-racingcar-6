package racingcar.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberTest {

    private static final int ZERO = 0;

    @Test
    @DisplayName("0~9 무작위 숫자 생성 테스트")
    void makeRandomNumber() {
        Set<String> examples = new HashSet<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        do {
            int randomNumber = RandomNumber.makeRandomNumber();
            examples.remove(Integer.toString(randomNumber));
        } while (!examples.isEmpty());

        assertEquals(ZERO, examples.size());
    }

}