package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @Test
    void getBooleanByNumber_메서드_사용시_숫자에_따른_참거짓_반환_확인(){
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Boolean> answers = Arrays.asList(false, false, false, false, true, true, true, true, true, true);

        for (int i=0; i<10; i++) {
            boolean result = Util.getBooleanByNumber(numbers.get(i));
            assertThat(result).isEqualTo(answers.get(i));
        }
    }

    @Test
    void getBooleanByNumber_메서드_사용시_한자리_숫자가_아닌_파라미터_입력_예외(){
        List<Integer> numbers = Arrays.asList(34, -1);

        for (int number : numbers) {
            assertThatThrownBy(() -> Util.getBooleanByNumber(number))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}