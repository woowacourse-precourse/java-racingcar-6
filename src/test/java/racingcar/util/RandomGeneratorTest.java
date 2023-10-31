package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * packageName    : racingcar.util
 * fileName       : RandomGeneratorTest
 * author         : qkrtn_ulqpbq2
 * date           : 2023-10-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-30        qkrtn_ulqpbq2       최초 생성
 */
public class RandomGeneratorTest {

    @Test
    @DisplayName("랜덤값 생성")
    public void makeRandomNumber(){
        int min = 0;
        int max = 9;

        int number = RandomGenerator.generateNumber(min, max);
        assertTrue(number >= 0 && number <= 9);
    }

}
