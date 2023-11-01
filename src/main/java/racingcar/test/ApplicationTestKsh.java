package racingcar.test;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.validation.UserInputValidation;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class ApplicationTestKsh extends NsTest {

    UserInputValidation userInputValidation = new UserInputValidation();
    @Test
    void 사용자가_입력한_자동차_이름_글자수_5자_이상() {
        String carName = "abcde";
        assertSimpleTest(()->
                assertThatThrownBy(()-> runException(carName))
                        .isInstanceOf(IllegalArgumentException.class));
    }
    @Test
    void 사용자가_입력한_자동차_이름들을_split_메소드로_구분_후_list에_저장() {
        String playerInput = "abc, def";
        List<String> list = new ArrayList<>();
        String[] result = playerInput.split(",");

        for (String carName: result) {
            list.add(carName);
        }
        assertThat(list).containsExactly("abc", "def");
    }

    @Test
    void 사용자가_입력한_시도횟수가_음수인_경우() {
        String playerInput = "-1";

        Throwable throwable = catchThrowable(() -> {
            userInputValidation.checkAttemptNumberValidation(playerInput);
        });

        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 사용자가_입력한_시도횟수가_숫자가_아닌_경우() {
        String playerInput = "abc";

        Throwable throwable = catchThrowable(() -> {
            userInputValidation.checkAttemptNumberValidation(playerInput);
        });

        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
