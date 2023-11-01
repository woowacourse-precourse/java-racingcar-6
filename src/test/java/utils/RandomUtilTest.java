package utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RandomUtilTest {

    @Test
    @DisplayName("랜덤 숫자 반환 테스트 (0 ~ 9 사이 숫자만 반환)")
    public void 랜덤숫자반환() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // when
        Integer randomNumber = RandomUtil.getRandomNumber();

        // then
        Assertions.assertThat(numbers).contains(randomNumber);
    }

}
