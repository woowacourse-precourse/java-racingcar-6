package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.exception.UserCarNameInputException;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserInputCarNameTest {
    private UserCarNameInputException userCarNameInputException;
    private UserInputCarName userInputCarName;
    @BeforeEach
    void setUp(){
        userCarNameInputException = new UserCarNameInputException();
    }
    @Test
    void 리스트_잘_나오는지_확인(){
        String input = "pobi,woni,jun";
        List<String> answer = Arrays.asList(input.split(","));
        UserInputCarName userInputCarName = new UserInputCarName();
        List<String> result = userInputCarName.createCarName(input);
        assertThat(result).isEqualTo(answer);
        System.out.println(result);

    }
}