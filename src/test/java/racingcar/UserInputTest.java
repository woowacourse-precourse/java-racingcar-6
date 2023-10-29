package racingcar;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

public class UserInputTest {

    @Test
    void 회수가_숫자_아닌_경우_예외_처리() {
        String input = "abc";
        Assertions.assertThat(!UserInput.isNumberInteger(input));
    }

    @Test
    void 회수가_0보다_작은_경우_예외_처리() {
        int input = 0;
        Assertions.assertThat(!UserInput.isNumberOverZero(input));
    }

    @Test
    void 이름이_공백인_경우_예외_처리() {
        String blank = " ";
        String includeBlank = "tom, ,yell";

        List<String> blankList = Arrays.asList(blank.split(","));
        List<String> includeBlankList = Arrays.asList(includeBlank.split(","));

        Assertions.assertThat(!UserInput.isNotEmpty(blankList));
        Assertions.assertThat(!UserInput.isNotEmpty(includeBlankList));
    }

}
