package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InitCarTest {

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
        String [] falseLengthValue = {"aa", "aaaaaa"};
        String [] falseNullValue =  {""};
        String [] falseBlankValue = {" "};

        assertThatCode(()-> test.checkCarsNameLength(trueValue))
                .doesNotThrowAnyException();
        assertThatThrownBy(() -> test.checkCarsNameLength(falseLengthValue))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> test.checkCarsNameLength(falseNullValue))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> test.checkCarsNameLength(falseBlankValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testSaveCars(){

        String [] input = {"aa", "bb", "cc"};
        test.saveCars(input);

        assertThat(test.carsMap)
                .containsEntry("aa","")
                .containsEntry("bb","")
                .containsEntry("cc","");
    }
}
