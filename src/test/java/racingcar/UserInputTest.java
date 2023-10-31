package racingcar;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserInputTest {

    UserInput userInput = new UserInput();

    @Test
    void 회수가_숫자_아닌_경우_예외_처리() {
        String input = "abc";
        assertThat(!UserInput.isNumberInteger(input));
    }

    @Test
    void 회수가_0보다_작은_경우_예외_처리() {
        int input = 0;
        assertThat(!UserInput.isNumberOverZero(input));
    }

    @Test
    void 이름이_공백인_경우_예외_처리() {
        String blank = "";
        String includeBlank = "tom, ,yell";

        List<String> blankList = Arrays.asList(blank.split(","));
        List<String> includeBlankList = Arrays.asList(includeBlank.split(","));

        assertThat(!UserInput.isNotEmpty(blankList));
        assertThat(!UserInput.isNotEmpty(includeBlankList));
    }

    @Test
    void 자동차_이름_입력_기능() {
        String wrongInput1 = "tomi,rabbit,sam";
        String wrongInput2 = "tomi, ,sam";
        // String OkInput = "tomi,sam,,";
        assertThatThrownBy(() -> {
                    userInput.getCarNamesInput(wrongInput1);
                })
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
                    userInput.getCarNamesInput(wrongInput2);
                })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력에_따른_리스트생성_보기() {
        String input1 = "tomi, ,sam";
        String input2 = "tomi,sam,,";

        List<String> list1 = Arrays.asList(input1.split(","));
        List<String> list2 = Arrays.asList(input2.split(","));

        assertThat(list1.size() == 3);
        assertThat(list2.size() == 2);
    }

    @Test
    void 경주_회수_입력_기능() {
        String input = "ABC";
        assertThatThrownBy(() -> {
                    userInput.getTryTimeInput(input);
                })
                .isInstanceOf(IllegalArgumentException.class);
    }

}
