package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.manager.view.UserViewValidation;

public class UserViewValidationTest {

    private final UserViewValidation userViewValidation = new UserViewValidation();
    @Test
    void 각_자리_문자가_숫자인지_판별_테스트(){
        String inputCount = "23";
        boolean expectedResult = userViewValidation.isDigit(inputCount);
        assertThat(expectedResult).isTrue();
    }
}
