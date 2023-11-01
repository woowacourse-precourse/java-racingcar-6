package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InitPlayerTest {

    RacingCar test = new RacingCar();

    @Test
    void testSplitCarsName(){

        String input = "aa,bb,cc";
        String [] falseValue = {"aa", "bb"};

        String [] result = test.splitCarsName(input);

        assertThat(result).containsExactly("aa","bb","cc");
        assertThat(result).isNotEqualTo(falseValue);
    }

    @Test
    void testCheckCarsNameLength(){

        String [] trueValue = {"a", "aa", "aaa", "aaaa", "aaaaa"};
        String [] falseValue = {"aa", "aaaaaa"};

        assertThatCode(()-> test.checkCarsNameLength(trueValue))
                .doesNotThrowAnyException();
        assertThatThrownBy(() -> test.checkCarsNameLength(falseValue))
                .isInstanceOf(IllegalArgumentException.class);



    }

}
